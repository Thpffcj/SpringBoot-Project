package cn.edu.nju.service;

import cn.edu.nju.vo.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户服务测试
 * Created by thpffcj on 2019-05-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    // {"data":{"baseInfo":{"sex":"m","name":"thpffcj","age":10},"otherInfo":{"address":"南京市","phone":"123456"},"id":161657},"errorCode":0,"errorMsg":""}
    @Test
    public void testCreateUser() throws Exception {

        User user = new User();
        user.setBaseInfo(
                new User.BaseInfo("thpffcj", 10, "m")
        );
        user.setOtherInfo(
                new User.OtherInfo("123456", "南京市")
        );

        System.out.println(JSON.toJSON(userService.createUser(user)));
    }
}
