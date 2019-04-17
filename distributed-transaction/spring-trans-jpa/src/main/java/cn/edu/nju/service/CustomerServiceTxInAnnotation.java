package cn.edu.nju.service;

import cn.edu.nju.dao.CustomerRepository;
import cn.edu.nju.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by thpffcj on 2019-04-16.
 */
@Service
public class CustomerServiceTxInAnnotation {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }
}
