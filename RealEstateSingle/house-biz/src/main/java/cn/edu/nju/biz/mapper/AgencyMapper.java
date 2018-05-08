package cn.edu.nju.biz.mapper;

import cn.edu.nju.common.model.Agency;
import cn.edu.nju.common.model.User;
import cn.edu.nju.common.page.PageParams;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thpffcj on 2018/5/7.
 */
@Mapper
@Component
public interface AgencyMapper {

    List<Agency> select(Agency agency);

    int insert(Agency agency);

    List<User> selectAgent(@Param("user") User user, @Param("pageParams") PageParams pageParams);

    Long selectAgentCount(@Param("user")User user);
}
