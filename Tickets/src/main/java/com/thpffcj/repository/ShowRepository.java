package com.thpffcj.repository;

import com.thpffcj.entity.Show;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public interface ShowRepository extends PagingAndSortingRepository<Show, Long> {

    Show findShowById(Long showId);

    List<Show> getAllByStatus(int status);
}
