package cn.edu.nju.repository;

import cn.edu.nju.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

/**
 * Created by Thpffcj on 2018/1/27.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String userName);
}
