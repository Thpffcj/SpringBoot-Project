package cn.edu.nju.repository;

import cn.edu.nju.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2017/10/22.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
