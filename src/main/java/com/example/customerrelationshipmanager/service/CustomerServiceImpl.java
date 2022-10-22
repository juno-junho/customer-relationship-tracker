//package com.example.customerrelationshipmanager.service;
//
//import com.example.customerrelationshipmanager.entity.Customer;
//import com.example.customerrelationshipmanager.repository.CustomerDAO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CustomerServiceImpl implements CustomerService{
//
//    // need to inject customer dao
//    private final CustomerDAO customerDAO;
//
//
//    @Override
//    @Transactional
//    public List<Customer> getCustomers() {
//        return customerDAO.getCustomers();
//    }
//
//
//    @Override
//    @Transactional
//    public void saveCustomer(Customer theCustomer) {
//        customerDAO.saveCustomer(theCustomer);
//
//    }
//
//    @Override
//    @Transactional
//    public Customer getCustomers(int theId) {
//        return customerDAO.getCustomers(theId);
//    }
//
//
//    @Override
//    @Transactional
//    public void deleteCustomer(int theId) {
//        customerDAO.deleteCustomer(theId);
//    }
//
//}