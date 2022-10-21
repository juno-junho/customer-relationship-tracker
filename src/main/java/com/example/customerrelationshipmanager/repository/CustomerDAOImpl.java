package com.example.customerrelationshipmanager.repository;

import com.example.customerrelationshipmanager.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDAOImpl implements CustomerDAO {

    private final EntityManager em;

    @Override
    public List<Customer> getCustomers() {
        return em.createQuery("select c from Customer c order by c.lastName", Customer.class).getResultList();
    }


    @Override
    public void saveCustomer(Customer theCustomer) {
        em.persist(theCustomer);
    }


    @Override
    public Customer getCustomers(int theId) {
        return em.find(Customer.class, theId);
    }


    @Override
    public void deleteCustomer(int theId) {
        em.remove(getCustomers(theId));
//        em.createQuery("delete from Customer c where c.id=:id", Customer.class).setParameter("id", theId).executeUpdate();
    }
}