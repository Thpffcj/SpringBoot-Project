package cn.edu.nju.dao;

import cn.edu.nju.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Merchants Dao 接口
 * Created by thpffcj on 2019-04-18.
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {

    /**
     * 根据 id 获取商户对象
     * @param id 商户 id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * 根据商户名称获取商户对象
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
