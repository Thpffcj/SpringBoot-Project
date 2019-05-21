package cn.edu.nju.web.controller;

import cn.edu.nju.biz.service.AgencyService;
import cn.edu.nju.biz.service.CommentService;
import cn.edu.nju.biz.service.HouseService;
import cn.edu.nju.common.constants.CommonConstants;
import cn.edu.nju.common.model.Comment;
import cn.edu.nju.common.model.House;
import cn.edu.nju.common.model.HouseUser;
import cn.edu.nju.common.model.UserMsg;
import cn.edu.nju.common.page.PageData;
import cn.edu.nju.common.page.PageParams;
import cn.edu.nju.common.result.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Thpffcj on 2018/5/5.
 */
@Controller
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private CommentService commentService;

    /**
     * 1.实现分页
     * 2.支持小区搜索、类型搜索
     * 3.支持排序
     * 4.支持展示图片、价格、标题、地址等信息
     *
     * @return
     */
    @RequestMapping("/house/list")
    public String houseList(Integer pageSize, Integer pageNum, House query, ModelMap modelMap) {
        PageData<House> ps = houseService.queryHouse(query, PageParams.build(pageSize, pageNum));
//        List<House> hotHouses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
//        modelMap.put("recomHouses", hotHouses);
        modelMap.put("ps", ps);
        modelMap.put("vo", query);
        return "house/listing";
    }

    /**
     * 查询房屋详情
     * 查询关联经纪人
     *
     * @param id
     * @return
     */
    @RequestMapping("house/detail")
    public String houseDetail(Long id, ModelMap modelMap) {
        House house = houseService.queryOneHouse(id);
        HouseUser houseUser = houseService.getHouseUser(id);
//        recommendService.increase(id);
        List<Comment> comments = commentService.getHouseComments(id, 8);
        if (houseUser.getUserId() != null && !houseUser.getUserId().equals(0)) {
            modelMap.put("agent", agencyService.getAgentDetail(houseUser.getUserId()));
        }
//        List<House> rcHouses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
//        modelMap.put("recomHouses", rcHouses);
        modelMap.put("house", house);
        modelMap.put("commentList", comments);
        return "/house/detail";
    }

    /**
     * 留言
     *
     * @param userMsg
     * @return
     */
    @RequestMapping("house/leaveMsg")
    public String houseMsg(UserMsg userMsg) {
        houseService.addUserMsg(userMsg);
        return "redirect:/house/detail?id=" + userMsg.getHouseId() + ResultMsg.successMsg("留言成功").asUrlParams();
    }
}
