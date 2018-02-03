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
    @GetMapping("/admin/welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

}
