package org.example.demo_aop_and_exception_handling.practice.p1.service;

import org.example.demo_aop_and_exception_handling.practice.p1.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll() throws Exception;
    Customer findOne(Long id) throws Exception;
}
