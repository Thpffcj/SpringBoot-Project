package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Thpffcj on 2018/1/30.
 */
@Controller
public class MemberController {

    @GetMapping("/member/login")
    public String loginPage() {
        return "member/login";
    }

    @PostMapping("/member/do_login")
    @ResponseBody
    public ApiResponse login() {
        System.out.println("-----------------------------------");
        return ApiResponse.ofSuccess("");
    }

    @GetMapping("/member/center")
    public String centerPage() {
        return "member/center";
    }
}
