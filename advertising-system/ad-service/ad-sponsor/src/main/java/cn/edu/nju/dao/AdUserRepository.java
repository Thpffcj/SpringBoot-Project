package cn.edu.nju.dao;

import cn.edu.nju.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thpffcj on 2019/8/26.
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long> {

    /**
     * 根据用户名查找用户记录
     * @param username
     * @return
     */
    AdUser findByUsername(String username);
}
