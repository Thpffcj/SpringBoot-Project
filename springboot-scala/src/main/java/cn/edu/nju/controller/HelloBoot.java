package cn.edu.nju.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thpffcj on 2019-05-21.
 */
@RestController
public class HelloBoot {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello Boot....";
    }
}
