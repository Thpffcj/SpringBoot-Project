package cn.edu.nju.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Thpffcj on 2018/1/27.
 */
@Controller
public class UserController {

    @GetMapping("/user/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/user/center")
    public String centerPage() {
        return "user/center";
    }
}
