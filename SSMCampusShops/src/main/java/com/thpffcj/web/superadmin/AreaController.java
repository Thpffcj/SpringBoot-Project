package com.thpffcj.web.superadmin;


import com.thpffcj.entity.Area;
import com.thpffcj.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Thpffcj on 2017/12/18.
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> areaList = new ArrayList<>();
        try {
            areaList = areaService.getAreaList();
            modelMap.put("rows", areaList);
            modelMap.put("total", areaList.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}