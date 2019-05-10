package cn.edu.nju.web;

import cn.edu.nju.dao.CustomerRepository;
import cn.edu.nju.domain.Customer;
import cn.edu.nju.service.CustomerServiceTxInAnnotation;
import cn.edu.nju.service.CustomerServiceTxInCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thpffcj on 2019-04-19.
 */
@RestController
@RequestMapping("/api/customer")
public class CustomResource {

    @Autowired
    private CustomerServiceTxInCode customerServiceTxInCode;

    @Autowired
    private CustomerServiceTxInAnnotation customerServiceTxInAnnotation;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/code")
    public Customer createInCode(@RequestBody Customer customer) {
        return customerServiceTxInCode.create(customer);
    }

    @PostMapping("/annotation")
    public Customer createInAnno(@RequestBody Customer customer) {
        return customerServiceTxInAnnotation.create(customer);
    }

    @GetMapping()
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
