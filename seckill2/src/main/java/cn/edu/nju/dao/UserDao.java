package cn.edu.nju.dao;

import cn.edu.nju.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * Created by Thpffcj on 2018/1/22.
 */
@Mapper
@Component
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") long id);

    @Update("update user set password = #{password} where id = #{id}")
    public void update(User toBeUpdate);
}
