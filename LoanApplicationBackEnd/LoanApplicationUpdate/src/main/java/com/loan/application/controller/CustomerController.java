package com.loan.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loan.application.module.Customer;
import com.loan.application.services.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("customer/{customerId}")
	private Customer getCustomerDetails(@PathVariable("customerId") String customerId) {
		return customerService.getCustomerDetails(customerId);
	}
	
	@GetMapping("/customer-Verification")
	private Customer CustomerVerfication(@RequestParam("email") String email, @RequestParam("password") String password) {
		return customerService.getCustomerDetails(email,password);
		
	}
	@PostMapping("/addCustomer")
	private Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomerDetails(customer);
	}

}
