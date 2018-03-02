package com.thpffcj.service;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public interface PayService {

    /**
     * 支付订单
     * @param phone
     * @param password
     * @param money
     * @return
     */
    ServiceResult payOrder(String phone, String password, double money);
}
