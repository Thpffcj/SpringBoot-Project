package com.thpffcj.service.impl;

import com.thpffcj.entity.Pay;
import com.thpffcj.repository.PayRepository;
import com.thpffcj.service.PayService;
import com.thpffcj.service.result.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thpffcj on 2018/2/9.
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    PayRepository payRepository;

    @Override
    @Transactional
    public ServiceResult payOrder(String account, String password, double money) {
        Pay pay = payRepository.findIdByPhoneAndPassword(account, password);
        if (pay == null) {
            return new ServiceResult(false, "");
        }
        double balance = pay.getMoney();
        if (balance < money) {
            return new ServiceResult(false, "");
        }
        payRepository.updateMoney(pay.getId(), balance - money);
        return ServiceResult.success();
    }

    @Override
    @Transactional
    public ServiceResult recharge(String account, double money) {
        Pay pay = payRepository.findByPhone(account);
        payRepository.updateMoney(pay.getId(), pay.getMoney() + money);
        return ServiceResult.success();
    }
}
