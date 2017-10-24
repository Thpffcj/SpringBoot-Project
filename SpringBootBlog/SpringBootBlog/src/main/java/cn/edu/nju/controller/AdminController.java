package cn.edu.nju.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Thpffcj on 2017/10/24.
 * 后台管理控制器.
 */
@RestController
@RequestMapping("/admins")
public class AdminController {


    /**
     * 获取后台管理主页面
     *
     * @return
     */
    @GetMapping
    public ModelAndView listUsers(Model model) {
        return new ModelAndView("admins/index", "menuList", model);
    }
}