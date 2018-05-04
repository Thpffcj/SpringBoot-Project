package cn.edu.nju.web;

import cn.edu.nju.biz.service.UserService;
import cn.edu.nju.common.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Thpffcj on 2018/5/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AuthTests {

    @Autowired
    private UserService userService;

    @Test
    public void testAuth() {
        User user =	userService.auth("1441732331@qq.com", "000000");
        assert user != null;
        System.out.println(user.getAboutme());
    }
}
