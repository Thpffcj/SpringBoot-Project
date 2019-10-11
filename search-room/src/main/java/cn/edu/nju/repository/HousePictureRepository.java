package cn.edu.nju.repository;

import cn.edu.nju.entity.HousePicture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Thpffcj on 2018/1/28.
 */
public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {

    List<HousePicture> findAllByHouseId(Long id);
}
