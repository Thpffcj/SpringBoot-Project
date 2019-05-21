package com.thpffcj.service;

import com.thpffcj.service.result.ServiceResult;

/**
 * Created by Thpffcj on 2018/2/9.
 */
public interface PayService {

    /**
     * 支付订单
     *
     * @param account
     * @param password
     * @param money
     * @return
     */
    ServiceResult payOrder(String account, String password, double money);

    ServiceResult recharge(String account, double money);
}
