package cn.edu.nju.service;

import cn.edu.nju.constant.FeedbackType;
import cn.edu.nju.vo.Feedback;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户反馈服务测试
 * Created by thpffcj on 2019-05-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest extends AbstractServiceTest {

    @Autowired
    private IFeedbackService feedbackService;

    @Test
    public void testCreateFeedback() {

        Feedback appFeedback = new Feedback();
        appFeedback.setUserId(userId);
        appFeedback.setType(FeedbackType.APP.getCode());
        appFeedback.setTemplateId("-1");
        appFeedback.setComment("分布式卡包学习");

        System.out.println(JSON.toJSONString(
                feedbackService.createFeedback(appFeedback)
        ));

        Feedback passFeedback = new Feedback();
        passFeedback.setUserId(userId);
        passFeedback.setType(FeedbackType.PASS.getCode());
        passFeedback.setTemplateId("3617cf73e7a1099097242115042cb7b0");
        passFeedback.setComment("优惠券评论");

        System.out.println(JSON.toJSONString(
                feedbackService.createFeedback(passFeedback)
        ));
    }

    @Test
    public void testGetFeedback() {

        System.out.println(JSON.toJSONString(feedbackService.getFeedback(userId)));
    }
}
