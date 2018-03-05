package com.thpffcj.repository;

import com.thpffcj.entity.VenueSeat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface VenueSeatRepository extends CrudRepository<VenueSeat, Long> {

    VenueSeat getByVenueIdAndName(Long venueId, String name);

    @Modifying
    @Query("update VenueSeat as venue_seat set venue_seat.remainingSeat = :remainingSeat where venue_seat.id = :id")
    void updateSeat(@Param(value = "id") Long id, @Param(value = "remainingSeat") int remainingSeat);
}
