package cn.edu.nju.repository;

import cn.edu.nju.ApplicationTests;
import cn.edu.nju.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Thpffcj on 2018/1/27.
 */
public class UserRepositoryTest extends ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("thpffcj", user.getName());
    }
}