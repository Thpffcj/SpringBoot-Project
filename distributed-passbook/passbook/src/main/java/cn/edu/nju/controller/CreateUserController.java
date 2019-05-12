package cn.edu.nju.controller;

import cn.edu.nju.log.LogConstants;
import cn.edu.nju.log.LogGenerator;
import cn.edu.nju.service.IUserService;
import cn.edu.nju.vo.Response;
import cn.edu.nju.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建用户服务
 * Created by thpffcj on 2019-05-12.
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class CreateUserController {

    // 创建用户服务
    private final IUserService userService;

    // HttpServletRequest
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public CreateUserController(IUserService userService, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }
    
    /**
     * 创建用户
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/createuser")
    Response createUser(@RequestBody User user) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                -1L, LogConstants.ActionName.CREATE_USER,
                user
        );
        return userService.createUser(user);
    }
}
