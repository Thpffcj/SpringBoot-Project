package com.thpffcj.repository;

import com.thpffcj.entity.Member;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Thpffcj on 2018/1/30.
 */
public interface MemberRepository extends CrudRepository<Member, Long> {
}
