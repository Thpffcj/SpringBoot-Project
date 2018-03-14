package com.thpffcj.repository;

import com.thpffcj.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> getAllByMemberIdAndStatus(Long memberId, int status);
}
