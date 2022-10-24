package com.junho.customerrelationshipmanager.controller;

import com.junho.customerrelationshipmanager.entity.Customer;
import com.junho.customerrelationshipmanager.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Customer> customers = customerService.findAll();
		
		// 회원 리스트
		theModel.addAttribute("customers", customers);
		// 시간 추가
		theModel.addAttribute("theDate", new java.util.Date());
		return "/customers/list-customers";
	}
	
	// 회원 추가
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		return "/customers/customer-form";
	}

	// 회원 업데이트
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {

		Customer theCustomer = customerService.findById(theId);
		theModel.addAttribute("customer", theCustomer);
		return "/customers/customer-form";
	}
	
	// 회원 저장
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("customer") Customer theCustomer) {

		customerService.save(theCustomer);
		return "redirect:/customers/list";
	}
	
	// 회원 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {

		customerService.deleteById(theId);
		return "redirect:/customers/list";
		
	}
	
	// 회원 검색
	@GetMapping("/search")
	public String delete(@RequestParam("customerName") String theName,
						 Model theModel) {

		List<Customer> customers = customerService.searchBy(theName);
		theModel.addAttribute("customers", customers);
		return "/customers/list-customers";
	}
}


















