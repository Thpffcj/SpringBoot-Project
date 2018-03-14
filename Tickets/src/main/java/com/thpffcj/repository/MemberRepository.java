package com.thpffcj.repository;

import com.thpffcj.entity.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Thpffcj on 2018/1/30.
 */
public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByMailAndPasswordAndStatus(String mail, String password, int status);

    Member findById(Long id);

    // member也是sql关键字
    @Modifying
    @Query("update Member as m set m.status = :status where m.id = :id")
    void updateDelete(@Param(value = "id") Long id, @Param(value = "status") int status);
}
