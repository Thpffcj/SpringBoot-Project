package cn.edu.nju.repository;

import cn.edu.nju.domain.User;

import java.util.List;

/**
 * Created by Thpffcj on 2017/10/22.
 */
public interface UserRepository {

    User saveOrUpdateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUser();
}
