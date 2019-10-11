package cn.edu.nju.repository;

import cn.edu.nju.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/27.
 * 角色数据DAO
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findRolesByUserId(Long userId);
}

