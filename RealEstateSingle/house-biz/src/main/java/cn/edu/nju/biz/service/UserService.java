package cn.edu.nju.biz.service;

import cn.edu.nju.biz.mapper.UserMapper;
import cn.edu.nju.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/9.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.selectUsers();
    }
}
