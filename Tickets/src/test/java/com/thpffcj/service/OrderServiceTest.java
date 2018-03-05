package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.web.dto.OrderDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class OrderServiceTest extends BaseTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void createOrder() {
        OrderDto orderDto = orderService.createOrder(1L, 1L, "测试", 100).getResult();
        System.out.println(orderDto);
    }
}