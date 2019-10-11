package cn.edu.nju.repository;

import cn.edu.nju.entity.Subway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/28.
 */
public interface SubwayRepository extends CrudRepository<Subway, Long> {

    List<Subway> findAllByCityEnName(String cityEnName);
}
