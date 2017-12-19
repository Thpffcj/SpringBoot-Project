package controller.system;

/**
 * Created by Thpffcj on 2017/9/5.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录相关
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    /**
     * 登录页面
     */
    @RequestMapping
    public String index() {
        return "/system/login";
    }
}
