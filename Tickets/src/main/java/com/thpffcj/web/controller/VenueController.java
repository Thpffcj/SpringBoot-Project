package com.thpffcj.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Thpffcj on 2018/1/30.
 */
@Controller
public class VenueController {

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/venue/welcome")
    public String welcomePage() {
        return "venue/welcome";
    }

    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/venue/center")
    public String adminCenterPage() {
        return "venue/center";
    }

    /**
     * 新增场馆功能页
     * @return
     */
    @GetMapping("venue/add/venue")
    public String addHousePage() {
        return "venue/venue-add";
    }

}
