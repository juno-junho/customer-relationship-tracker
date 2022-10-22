//package com.example.customerrelationshipmanager.controller;
//
//import com.example.customerrelationshipmanager.entity.Customer;
//import com.example.customerrelationshipmanager.service.CustomerService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/customer")
//@RequiredArgsConstructor
//@Slf4j
//public class CustomerController {
//
//    private final CustomerService customerService;
//
//    @GetMapping("/list")
//    public String listCustomers(Model theModel){
//        List<Customer> theCustomers = customerService.getCustomers();
//        theModel.addAttribute("customers", theCustomers);
//        return "list-customers";
//    }
//
//    @GetMapping("/showFormForAdd")
//    public String showFormForAdd(Model theModel) {
//        Customer theCustomer = new Customer();
//        theModel.addAttribute("customer",theCustomer);
//        log.info("Name : " + theCustomer.getFirstName() + " " + theCustomer.getLastName());
//        return "customer-form";
//    }
//
//    @PostMapping("/saveCustomer")
//    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
//        customerService.saveCustomer(theCustomer);
//        log.info("Name : " + theCustomer.getFirstName() + " " + theCustomer.getLastName());
//        return "redirect:/customer/list";
//    }
//
//    @GetMapping("/showFormForUpdate")
//    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
//        Customer theCustomer = customerService.getCustomers(theId);
//        theModel.addAttribute("customer", theCustomer);
//        log.info("Name : " + theCustomer.getFirstName() + " " + theCustomer.getLastName());
//        return "customer-form";
//    }
//    @GetMapping("/delete")
//    public String deleteCustomer(@RequestParam("customerId") int theId) {
//        log.info("Name : " + customerService.getCustomers(theId).getLastName() + " " + customerService.getCustomers(theId).getFirstName());
//        customerService.deleteCustomer(theId);
//        return "redirect:/customer/list";
//    }
//}