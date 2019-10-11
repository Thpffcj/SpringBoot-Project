package cn.edu.nju.order.mapper;

import cn.edu.nju.order.pojo.Orders;
import cn.edu.nju.order.pojo.OrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/30.
 */
public interface OrdersMapper {

    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
}
