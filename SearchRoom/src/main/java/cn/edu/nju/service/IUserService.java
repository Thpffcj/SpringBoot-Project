package cn.edu.nju.service;

import cn.edu.nju.entity.User;

/**
 * Created by Thpffcj on 2018/1/27.
 */
public interface IUserService {

    User findUserByName(String userName);
}
