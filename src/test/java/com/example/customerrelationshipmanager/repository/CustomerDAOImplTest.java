//package com.example.customerrelationshipmanager.repository;
//
//import com.example.customerrelationshipmanager.entity.Customer;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class CustomerDAOImplTest {
//
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private CustomerDAO customerDAO;
//
//    @Test
//    void 고객_저장() throws Exception {
//        // given
//        Customer customer = new Customer("Junho", "Hwang", "ssmm0205@naver.com");
//
//        // when
//        customerDAO.saveCustomer(customer);
//
//        // then
//        Customer output = em.find(Customer.class, customer.getId());;
//        assertEquals(customer, output, "저장하고 꺼낼때 같아야 한다.");
//    }
//
//    @Test
//    void 고객_조회() throws Exception {
//        // given
//        Customer customer = new Customer("Junho", "Hwang", "ssmm0205@naver.com");
//        em.persist(customer);
//
//        // when
//        Customer output = customerDAO.getCustomers(customer.getId());
//
//        // then
//        assertEquals(customer, output, "저장후 꺼내는것이 값이 같아야 한다.");
//
//    }
//
//    @Test
//    void 고객_삭제() throws Exception {
//
//        // null check
//        assertNotNull(customerDAO.getCustomers(1), "해당 값이 없습니다");
//
//        Customer customer = customerDAO.getCustomers(1);
//        // delete
//        customerDAO.deleteCustomer(customer.getId());
//
//        assertNull(customerDAO.getCustomers(1), "해당 값이 삭제되지 않았습니다.");
//    }
//}