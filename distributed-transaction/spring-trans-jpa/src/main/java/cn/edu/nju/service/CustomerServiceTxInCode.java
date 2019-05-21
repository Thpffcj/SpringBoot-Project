package cn.edu.nju.service;

import cn.edu.nju.dao.CustomerRepository;
import cn.edu.nju.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * Created by thpffcj on 2019-04-16.
 */
@Service
public class CustomerServiceTxInCode {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public Customer create(Customer customer) {

        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);

        TransactionStatus status = transactionManager.getTransaction(definition);

        try {
            customerRepository.save(customer);
            transactionManager.commit(status);
            return customer;
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
