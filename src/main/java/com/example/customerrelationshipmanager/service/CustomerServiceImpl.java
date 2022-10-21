package com.example.customerrelationshipmanager.service;

import com.example.customerrelationshipmanager.entity.Customer;
import com.example.customerrelationshipmanager.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    // need to inject customer dao
    @Autowired
    private CustomerDAO customerDAO;


    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }


    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);

    }


    @Override
    @Transactional
    public Customer getCustomers(int theId) {
        // TODO Auto-generated method stub
        return customerDAO.getCustomers(theId);
    }


    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }

}