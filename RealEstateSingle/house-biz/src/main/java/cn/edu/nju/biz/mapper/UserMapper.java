package cn.edu.nju.biz.mapper;

import cn.edu.nju.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thpffcj on 2018/4/9.
 */
@Mapper
@Component
public interface UserMapper {

    public List<User> selectUsers();

    public int insert(User account);

    public int delete(String email);

    public int update(User updateUser);

    public List<User> selectUsersByQuery(User user);
}
