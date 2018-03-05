package com.thpffcj.repository;

import com.thpffcj.entity.Venue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public interface VenueRepository extends CrudRepository<Venue, Long> {

    Venue findById(Long venueId);

    List<Venue> findAllByStatus(int status);

    @Modifying
    @Query("update Venue as venue set venue.status = :status where venue.id = :id")
    void updateStatus(@Param(value = "id") Long id, @Param(value = "status") int status);
}
