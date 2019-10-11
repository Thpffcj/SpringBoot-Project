package com.thpffcj.repository;

import com.thpffcj.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Modifying
    @Query("update Order as o set o.status = :status where o.id = :orderId")
    void updateStatus(@Param(value = "orderId") Long orderId,
                      @Param(value = "status") int status);

    List<Order> getAllByMemberIdAndStatus(Long memberId, int status);

    List<Order> getAllByVenueIdAndStatus(Long venueId, int status);
}
