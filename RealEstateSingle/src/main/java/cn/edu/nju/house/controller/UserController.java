package cn.edu.nju.house.controller;

import cn.edu.nju.house.common.model.User;
import cn.edu.nju.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/9.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}