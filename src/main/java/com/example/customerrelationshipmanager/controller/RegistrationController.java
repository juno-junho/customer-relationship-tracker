//package com.example.customerrelationshipmanager.controller;
//import com.example.customerrelationshipmanager.entity.CRMUser;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/register")
//@RequiredArgsConstructor
//@Slf4j
//public class RegistrationController {
//
//	private final UserDetailsManager userDetailsManager;
//
//	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//	@InitBinder
//	public void initBinder(WebDataBinder dataBinder) {
//
//		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//
//		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//	}
//
//	@GetMapping("/showRegistrationForm")
//	public String showMyLoginPage(Model theModel) {
//
//		theModel.addAttribute("crmUser", new CRMUser());
//
//		return "registration-form";
//
//	}
//
//	@PostMapping("/processRegistrationForm")
//	public String processRegistrationForm(
//				@Valid @ModelAttribute("crmUser") User theCrmUser,
//				BindingResult theBindingResult,
//				Model theModel) {
//
//		String userName = theCrmUser.getUsername();
//
//		log.info("Processing registration form for: " + userName);
//
//		// form validation
//		if (theBindingResult.hasErrors()) {
//
//			theModel.addAttribute("crmUser", new CRMUser());
//			theModel.addAttribute("registrationError", "User name/password can not be empty.");
//
//			log.warn("User name/password can not be empty.");
//
//			return "registration-form";
//		}
//
//		// check the database if user already exists
//		boolean userExists = doesUserExist(userName);
//
//		if (userExists) {
//			theModel.addAttribute("crmUser", new CRMUser());
//			theModel.addAttribute("registrationError", "User name already exists.");
//
//			log.warn("User name already exists.");
//
//			return "registration-form";
//		}
//
//		//
//		// whew ... we passed all of the validation checks!
//		// let's get down to business!!!
//		//
//
//		// encrypt the password
//        String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());
//
//        // prepend the encoding algorithm id
//        encodedPassword = "{bcrypt}" + encodedPassword;
//
//		// give user default role of "employee"
//        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
//
//        // create user object (from Spring Security framework)
//        User tempUser = new User(userName, encodedPassword, authorities);
//
//        // save user in the database
//        userDetailsManager.createUser(tempUser);
//
//        log.info("Successfully created user: " + userName);
//
//        return "registration-confirmation";
//	}
//
//	private boolean doesUserExist(String userName) {
//
//		log.info("Checking if user exists: " + userName);
//
//		// check the database if the user already exists
//		boolean exists = userDetailsManager.userExists(userName);
//
//		log.info("User: " + userName + ", exists: " + exists);
//
//		return exists;
//	}
//
//}
