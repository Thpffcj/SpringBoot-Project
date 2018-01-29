package cn.edu.nju.service;

import cn.edu.nju.entity.User;
import cn.edu.nju.web.dto.UserDTO;

/**
 * Created by Thpffcj on 2018/1/27.
 */
public interface IUserService {

    User findUserByName(String userName);

    ServiceResult<UserDTO> findById(Long userId);
}
