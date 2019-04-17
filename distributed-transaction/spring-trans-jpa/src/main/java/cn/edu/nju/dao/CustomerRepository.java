package cn.edu.nju.dao;

import cn.edu.nju.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by thpffcj on 2019-04-16.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findOneByUsername(String username);
}
