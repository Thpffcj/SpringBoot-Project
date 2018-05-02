package cn.edu.nju.user.service;

import cn.edu.nju.thrift.user.UserInfo;
import cn.edu.nju.thrift.user.UserService;
import org.apache.thrift.TException;

/**
 * Created by Thpffcj on 2018/5/1.
 */
public class UserServiceImpl implements UserService.Iface {

    @Override
    public UserInfo getUserById(int id) throws TException {
        return null;
    }

    @Override
    public UserInfo getTeacherById(int id) throws TException {
        return null;
    }

    @Override
    public UserInfo getUserByName(String username) throws TException {
        return null;
    }

    @Override
    public void registerUser(UserInfo userInfo) throws TException {

    }
}
