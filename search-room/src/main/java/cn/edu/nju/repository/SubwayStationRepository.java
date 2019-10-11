package cn.edu.nju.repository;

import cn.edu.nju.entity.SubwayStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/28.
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {

    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
