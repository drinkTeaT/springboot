package com.learn.jpa.repository;

import com.learn.jpa.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-01-01 16:39
 **/
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}