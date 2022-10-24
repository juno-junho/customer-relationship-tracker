package com.junho.customerrelationshipmanager.service;

import com.junho.customerrelationshipmanager.entity.Customer;
import com.junho.customerrelationshipmanager.repository.CustomerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAllByOrderByLastNameAsc();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerDAO.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        }
        else {
            // 회원을 찾을 수 없을 때
            throw new RuntimeException("다음 id의 회원을 찾을 수 없었습니다. - " + theId);
        }

        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        customerDAO.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);
    }

    @Override
    public List<Customer> searchBy(String theName) {

        List<Customer> results = null;

        if (theName != null && (theName.trim().length() > 0)) {
            results = customerDAO.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
        }
        else {
            results = findAll();
        }

        return results;
    }

}

