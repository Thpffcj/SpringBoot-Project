package cn.edu.nju.service;

import cn.edu.nju.exception.AdException;
import cn.edu.nju.vo.CreateUserRequest;
import cn.edu.nju.vo.CreateUserResponse;

/**
 * Created by thpffcj on 2019/8/26.
 */
public interface IUserService {

    /**
     * 创建用户
     * @param request
     * @return
     * @throws AdException
     */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
