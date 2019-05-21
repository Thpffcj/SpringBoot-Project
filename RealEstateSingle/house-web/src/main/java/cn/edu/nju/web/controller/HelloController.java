package cn.edu.nju.web.controller;

import cn.edu.nju.biz.service.UserService;
//import cn.edu.nju.model.User;
import cn.edu.nju.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/9.
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("hello")
    public String hello(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        User one = users.get(0);
        modelMap.put("user", one);
        return "hello";
    }

    @RequestMapping("index")
    public String index() {
        return "homepage/index";
    }
}
