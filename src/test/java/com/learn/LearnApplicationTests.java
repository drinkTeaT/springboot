package com.learn;

import com.learn.jpa.entities.Customer;
import com.learn.jpa.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnApplicationTests {
    // spring data jpa
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
        dataJpa();
    }

    // spring data jpa
    private void dataJpa(){
        // 存数据
        customerRepository.save(new Customer("jack","baur"));
        // 查数据
        List<Customer> customers = customerRepository.findByLastName("baur");
        System.out.println(customers.get(0).toString());
    }
}

