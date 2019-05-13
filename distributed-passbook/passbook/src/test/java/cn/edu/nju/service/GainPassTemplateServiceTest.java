package cn.edu.nju.service;

import cn.edu.nju.vo.GainPassTemplateRequest;
import cn.edu.nju.vo.PassTemplate;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 用户领取优惠券功能测试
 * Created by thpffcj on 2019-05-13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GainPassTemplateServiceTest extends AbstractServiceTest {

    @Autowired
    private IGainPassTemplateService gainPassTemplateService;

    @Test
    public void testGainPassTemplate() throws Exception {

        PassTemplate target = new PassTemplate();
        target.setId(9);
        target.setTitle("慕课-2");
        target.setHasToken(true);

        System.out.println(JSON.toJSONString(
                gainPassTemplateService.gainPassTemplate(
                        new GainPassTemplateRequest(userId, target)
                )
        ));
    }
}
