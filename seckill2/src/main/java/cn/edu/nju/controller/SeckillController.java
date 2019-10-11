package cn.edu.nju.controller;

import cn.edu.nju.access.AccessLimit;
import cn.edu.nju.domain.OrderInfo;
import cn.edu.nju.domain.SeckillOrder;
import cn.edu.nju.domain.User;
import cn.edu.nju.rabbitmq.MQSender;
import cn.edu.nju.rabbitmq.SeckillMessage;
import cn.edu.nju.redis.GoodsKey;
import cn.edu.nju.redis.OrderKey;
import cn.edu.nju.redis.RedisService;
import cn.edu.nju.redis.SeckillKey;
import cn.edu.nju.result.CodeMsg;
import cn.edu.nju.result.Result;
import cn.edu.nju.service.GoodsService;
import cn.edu.nju.service.OrderService;
import cn.edu.nju.service.SeckillService;
import cn.edu.nju.service.UserService;
import cn.edu.nju.vo.GoodsVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Thpffcj on 2018/1/24.
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController implements InitializingBean {

    private static Logger log = LoggerFactory.getLogger(SeckillController.class);

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    SeckillService seckillService;

    @Autowired
    MQSender sender;

    private HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();

    /**
     * 系统初始化
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        if (goodsList == null) {
            return;
        }
        for (GoodsVo goods : goodsList) {
            redisService.set(GoodsKey.getSeckillGoodsStock, "" + goods.getId(), goods.getStockCount());
            localOverMap.put(goods.getId(), false);
        }
    }

    @AccessLimit(seconds = 5, maxCount = 5, needLogin = true)
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getSeckillPath(HttpServletRequest request, User user,
                                         @RequestParam("goodsId") long goodsId,
                                         @RequestParam(value = "verifyCode", defaultValue = "0") int verifyCode) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        boolean check = seckillService.checkVerifyCode(user, goodsId, verifyCode);
        if (!check) {
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        String path = seckillService.createSeckillPath(user, goodsId);
        return Result.success(path);
    }

    @RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
    @ResponseBody
    public Result<String> getSeckillVerifyCode(HttpServletResponse response, User user,
                                               @RequestParam("goodsId") long goodsId) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        try {
            BufferedImage image = seckillService.createVerifyCode(user, goodsId);
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);
            out.flush();
            out.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.SECKILL_FAIL);
        }
    }

    @RequestMapping(value = "/{path}/do_seckill", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> seckill(Model model, User user,
                                   @RequestParam("goodsId") long goodsId,
                                   @PathVariable("path") String path) {
        model.addAttribute("user", user);
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        // 验证path
        boolean check = seckillService.checkPath(user, goodsId, path);
        if (!check) {
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        // 内存标记，减少redis访问
        boolean over = localOverMap.get(goodsId);
        if (over) {
            return Result.error(CodeMsg.SECKILL_OVER);
        }
        // 预减库存
        long stock = redisService.decr(GoodsKey.getSeckillGoodsStock, "" + goodsId); // 10
        if (stock < 0) {
            localOverMap.put(goodsId, true);
            return Result.error(CodeMsg.SECKILL_OVER);
        }
        // 判断是否已经秒杀到了
        SeckillOrder order = orderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_SECKILL);
        }
        // 入队
        SeckillMessage message = new SeckillMessage();
        message.setUser(user);
        message.setGoodsId(goodsId);
        sender.sendSeckillMessage(message);
        return Result.success(0); // 排队中
    }

    /**
     * orderId：成功
     * -1：秒杀失败
     * 0： 排队中
     *
     * @param model
     * @param user
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public Result<Long> seckillResult(Model model, User user,
                                      @RequestParam("goodsId") long goodsId) {
        model.addAttribute("user", user);
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        long result = seckillService.getSeckillResult(user.getId(), goodsId);
        return Result.success(result);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    @ResponseBody
    public Result<Boolean> reset(Model model) {
        List<GoodsVo> goodsList = goodsService.listGoodsVo();
        for (GoodsVo goods : goodsList) {
            goods.setStockCount(10);
            redisService.set(GoodsKey.getSeckillGoodsStock, "" + goods.getId(), 10);
            localOverMap.put(goods.getId(), false);
        }
        redisService.delete(OrderKey.getSeckillOrderByUidGid);
        redisService.delete(SeckillKey.isGoodsOver);
        seckillService.reset(goodsList);
        return Result.success(true);
    }

    //    @RequestMapping("/do_seckill")
//    public String list(Model model, User user,
//                       @RequestParam("goodsId") long goodsId) {
//        model.addAttribute("user", user);
//        if (user == null) {
//            return "login";
//        }
//        // 判断库存
//        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
//        int stock = goods.getStockCount();
//        if (stock <= 0) {
//            model.addAttribute("errmsg", CodeMsg.SECKILL_OVER.getMsg());
//            return "seckill_fail";
//        }
//        // 判断是否已经秒杀到了
//        SeckillOrder order = orderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
//        if (order != null) {
//            model.addAttribute("errmsg", CodeMsg.REPEATE_SECKILL.getMsg());
//            return "seckill_fail";
//        }
//        // 减库存 下订单 写入秒杀订单
//        OrderInfo orderInfo = seckillService.seckill(user, goods);
//        model.addAttribute("orderInfo", orderInfo);
//        model.addAttribute("goods", goods);
//        return "order_detail";
//    }

//    @RequestMapping(value = "/do_seckill", method = RequestMethod.POST)
//    @ResponseBody
//    public Result<OrderInfo> seckill(Model model, User user,
//                                     @RequestParam("goodsId") long goodsId) {
//        model.addAttribute("user", user);
//        if (user == null) {
//            return Result.error(CodeMsg.SESSION_ERROR);
//        }
//        // 判断库存
//        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
//        int stock = goods.getStockCount();
//        if (stock <= 0) {
//            model.addAttribute("errmsg", CodeMsg.SECKILL_OVER.getMsg());
//            return Result.error(CodeMsg.SECKILL_OVER);
//        }
//        // 判断是否已经秒杀到了
//        SeckillOrder order = orderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
//        if (order != null) {
//            model.addAttribute("errmsg", CodeMsg.REPEATE_SECKILL.getMsg());
//            return Result.error(CodeMsg.REPEATE_SECKILL);
//        }
//        // 减库存 下订单 写入秒杀订单
//        OrderInfo orderInfo = seckillService.seckill(user, goods);
//        return Result.success(orderInfo);
//    }
}
