package cn.edu.nju.service;

import cn.edu.nju.domain.OrderInfo;
import cn.edu.nju.domain.User;
import cn.edu.nju.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thpffcj on 2018/1/24.
 */
@Service
public class SeckillService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Transactional
    public OrderInfo seckill(User user, GoodsVo goods) {
        // 减库存 下订单 写入秒杀订单
        goodsService.reduceStock(goods);
        // order_info seckill_order
        return orderService.createOrder(user, goods);
    }
}
