package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.service.PayService;
import com.thpffcj.service.ServiceResult;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

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