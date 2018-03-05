package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Thpffcj on 2018/1/30.
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/login")
    public String loginPage() {
        return "member/login";
    }

    @PostMapping("/member/do_login")
    @ResponseBody
    public ApiResponse login(@RequestParam(value = "mail") String mail,
                             @RequestParam(value = "password") String password) {
        return ApiResponse.ofSuccess("");
    }

    @GetMapping("/member/center")
    public String centerPage() {
        return "member/center";
    }
}
