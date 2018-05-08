package cn.edu.nju.biz.mapper;

import cn.edu.nju.common.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Thpffcj on 2018/5/7.
 */
@Mapper
@Component
public interface CommentMapper {

    List<Comment> selectComments(@Param("houseId")long houseId, @Param("size")int size);
}
