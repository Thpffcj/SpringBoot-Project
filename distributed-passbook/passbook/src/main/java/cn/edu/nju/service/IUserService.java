package cn.edu.nju.service;

import cn.edu.nju.vo.Response;
import cn.edu.nju.vo.User;

/**
 * 用户服务：创建 User 服务
 * Created by thpffcj on 2019-05-07.
 */
public interface IUserService {

    /**
     * 创建用户
     *
     * @param user {@link User}
     * @return {@link Response}
     * @throws Exception
     */
    Response createUser(User user) throws Exception;
}
