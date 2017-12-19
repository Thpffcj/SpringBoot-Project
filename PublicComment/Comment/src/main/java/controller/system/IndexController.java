package controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Thpffcj on 2017/8/31.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping
    public String init() {
        System.out.println("start");
        return "/system/index";
    }

}
