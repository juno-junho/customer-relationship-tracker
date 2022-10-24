package com.junho.customerrelationshipmanager.repository;

import com.junho.customerrelationshipmanager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByOrderByLastNameAsc();

    List<Customer> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);
}