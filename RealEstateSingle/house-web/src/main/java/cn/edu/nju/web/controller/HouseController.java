package cn.edu.nju.web.controller;

import cn.edu.nju.biz.service.HouseService;
import cn.edu.nju.common.constants.CommonConstants;
import cn.edu.nju.common.model.House;
import cn.edu.nju.common.page.PageData;
import cn.edu.nju.common.page.PageParams;
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

    /**
     * 1.实现分页
     * 2.支持小区搜索、类型搜索
     * 3.支持排序
     * 4.支持展示图片、价格、标题、地址等信息
     * @return
     */
    @RequestMapping("/house/list")
    public String houseList(Integer pageSize,Integer pageNum,House query,ModelMap modelMap){
        PageData<House> ps =  houseService.queryHouse(query, PageParams.build(pageSize, pageNum));
//        List<House> hotHouses =  recommendService.getHotHouse(CommonConstants.RECOM_SIZE);
//        modelMap.put("recomHouses", hotHouses);
        modelMap.put("ps", ps);
        modelMap.put("vo", query);
        return "house/listing";
    }
}
