package cn.edu.nju.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by thpffcj on 2019-04-16.
 */
@RestController
@RequestMapping("/api")
public class HomeResource {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World;";
    }
}
