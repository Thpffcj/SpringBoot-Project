package com.thpffcj.dao;

/**
 * Created by Thpffcj on 2018/1/21.
 */
public interface MemberDao {

    /**
     * 注册新用户
     * @param mail
     * @param password
     * @return
     */
    int register(String mail, String password);

    /**
     * 用户登录
     * @param mail
     * @param password
     * @return
     */
    int login(String mail, String password);
}
