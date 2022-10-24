package com.junho.customerrelationshipmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String welcomePage(){
		return "redirect:customers/list";
	}

	// 로그인 페이지
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "login";
		
	}
	
	// 접근 불가 페이지
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
		
	}
	
}