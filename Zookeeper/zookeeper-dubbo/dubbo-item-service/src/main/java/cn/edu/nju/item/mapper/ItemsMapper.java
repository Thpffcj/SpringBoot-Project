package cn.edu.nju.item.mapper;

import cn.edu.nju.item.pojo.Items;
import cn.edu.nju.item.pojo.ItemsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/29.
 */
public interface ItemsMapper {

    int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);

    int reduceCounts(Items record);
}
