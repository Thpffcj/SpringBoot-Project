package cn.edu.nju.service;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户优惠券服务测试
 * Created by thpffcj on 2019-05-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPassServiceTest extends AbstractServiceTest {

    @Autowired
    private IUserPassService userPassService;

    @Test
    public void testGetUserPassInfo() throws Exception {

        System.out.println(JSON.toJSONString(userPassService.getUserPassInfo(userId)));
    }

    @Test
    public void testGetUserUsedPassInfo() throws Exception {

        System.out.println(JSON.toJSONString(userPassService.getUserUsedPassInfo(userId)));
    }

    @Test
    public void testGetUserAllPassInfo() throws Exception {

        System.out.println(JSON.toJSONString(userPassService.getUserAllPassInfo(userId)));
    }
}
