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
     * 场馆管理员登录
     * @return
     */
    @GetMapping("/venue/login")
    public String venueLoginPage() {
        return "venue/login";
    }

    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/venue/center")
    public String venueCenterPage() {
        return "venue/center";
    }

    /**
     * 新增场馆功能页
     * @return
     */
    @GetMapping("venue/add/show")
    public String addHousePage() {
        return "venue/show-add";
    }

}
