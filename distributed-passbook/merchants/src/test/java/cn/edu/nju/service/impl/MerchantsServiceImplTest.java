package cn.edu.nju.service.impl;

import cn.edu.nju.service.IMerchantsService;
import cn.edu.nju.vo.CreateMerchantsRequest;
import cn.edu.nju.vo.PassTemplate;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 商户服务测试类
 * Created by thpffcj on 2019-04-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServiceImplTest {

    @Autowired
    private IMerchantsService merchantsService;

    @Test
    @Transactional
    public void createMerchants() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("Thpffcj2");
        request.setLogoUrl("www.thpffcj.com");
        request.setBusinessLicenseUrl("www.thpffcj.com");
        request.setPhone("1234567890");
        request.setAddress("北京市");

        System.out.println(JSON.toJSONString(merchantsService.createMerchants(request)));
    }

    @Test
    public void buildMerchantsInfoById() {
        System.out.println(JSON.toJSONString(merchantsService.buildMerchantsInfoById(18)));
    }

    @Test
    public void dropPassTemplate() {

        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(9);
        passTemplate.setTitle("慕课-2");
        passTemplate.setSummary("简介: 慕课");
        passTemplate.setDesc("详情: 慕课");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(true);
        passTemplate.setBackground(2);
        passTemplate.setStart(DateUtils.addDays(new Date(), -10));
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(
                merchantsService.dropPassTemplate(passTemplate)
        ));
    }
}