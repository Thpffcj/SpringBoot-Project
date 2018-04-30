package cn.edu.nju.biz.mapper;

import cn.edu.nju.common.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/9.
 */
@Mapper
public interface UserMapper {

    public List<User> selectUsers();
}
