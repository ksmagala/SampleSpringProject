package com.sample.spring.project.springboot.services;

import com.sample.spring.project.springboot.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();

    Customer saveCustomer(Customer customer);
}
