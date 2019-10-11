package com.thpffcj.repository;

import com.thpffcj.entity.Show;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface ShowRepository extends PagingAndSortingRepository<Show, Long> {

    Show findShowById(Long showId);

    Show findShowByName(String showName);

    List<Show> getAllByStatus(int status);

    @Modifying
    @Query("update Show as s set s.status = :status where s.id = :id")
    void updateStatus(@Param(value = "id") Long showName, @Param(value = "status") int status);
}
