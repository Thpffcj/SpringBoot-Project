package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.service.result.ServiceResult;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public class PayServiceTest extends BaseTest {

    @Autowired
    private PayService payService;

    @Test
    public void payOrder() {
        ServiceResult serviceResult = payService.payOrder("13888888888", "123456", 30);
        Assert.assertTrue(serviceResult.isSuccess());
    }
}