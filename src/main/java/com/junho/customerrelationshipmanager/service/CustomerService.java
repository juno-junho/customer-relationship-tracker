package com.junho.customerrelationshipmanager.service;

import com.junho.customerrelationshipmanager.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public void save(Customer theCustomer);

    public Customer findById(int theId);

    public void deleteById(int theId);

    public List<Customer> searchBy(String theName);
}
