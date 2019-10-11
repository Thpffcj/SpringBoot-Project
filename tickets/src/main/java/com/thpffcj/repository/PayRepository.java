package com.thpffcj.repository;

import com.thpffcj.entity.Pay;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public interface PayRepository extends CrudRepository<Pay, Integer> {

    Pay findByPhone(String phone);

    /**
     * 查询账户
     *
     * @param phone
     * @param password
     * @return
     */
    Pay findIdByPhoneAndPassword(String phone, String password);

    /**
     * 支付账单
     *
     * @param id
     * @param money
     */
    @Modifying
    @Query("update Pay as pay set pay.money = :money where id = :id")
    void updateMoney(@Param(value = "id") Long id, @Param(value = "money") double money);
}
