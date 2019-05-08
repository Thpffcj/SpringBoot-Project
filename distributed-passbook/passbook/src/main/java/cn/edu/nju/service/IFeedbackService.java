package cn.edu.nju.service;

import cn.edu.nju.vo.Feedback;
import cn.edu.nju.vo.Response;

/**
 * 评论功能：即用户评论相关功能实现
 * Created by thpffcj on 2019-05-08.
 */
public interface IFeedbackService {

    /**
     * 创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    Response createFeedback(Feedback feedback);

    /**
     * 获取用户评论
     * @param userId 用户 id
     * @return {@link Response}
     */
    Response getFeedback(Long userId);
}
