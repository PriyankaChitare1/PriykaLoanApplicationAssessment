package com.loan.application.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.module.Customer;
import com.loan.application.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public Customer getCustomerDetails(String customerId) {
		logger.info("Here we are getting customer details .", customerId);
		return customerRepository.findById(customerId).get();
	}

	public Customer getCustomerDetails(String email, String password) {
		List<Customer> customerList = customerRepository.findByEmailAndPassword(email, password);
		if (customerList.isEmpty()) {
			return new Customer();
		}
		logger.info("Here we are Verifing existing Customer Details for emialId and password", email, password);

		return customerRepository.findByEmailAndPassword(email, password).get(0);
	}

	public Customer saveCustomerDetails(Customer customer) {
		customer.setCustomerId(generatekey("CID"));
		logger.info("Here we are Saving Customer Details" ,customer);
		return customerRepository.save(customer);
	}

	private String generatekey(String prefix) {
		String key = UUID.randomUUID().toString().split("-")[0];
		return prefix + key;
	}

}
