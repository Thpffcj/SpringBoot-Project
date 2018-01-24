package cn.edu.nju.repository;

import cn.edu.nju.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by Thpffcj on 2017/10/23.
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
    /**
     * 根据用户名分页查询用户列表
     * @param pageable
     * @return
     */
    Page<Blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
}
