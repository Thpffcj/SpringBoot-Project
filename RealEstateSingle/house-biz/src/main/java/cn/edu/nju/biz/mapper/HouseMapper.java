package cn.edu.nju.biz.mapper;

import cn.edu.nju.common.model.Community;
import cn.edu.nju.common.model.House;
import cn.edu.nju.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thpffcj on 2018/5/5.
 */
@Mapper
@Component
public interface HouseMapper {

    public List<House> selectPageHouses(@Param("house") House house, @Param("pageParams") PageParams pageParams);

    public Long selectPageCount(@Param("house") House query);

    public List<Community> selectCommunity(Community community);

    public int insert(House house);
}
