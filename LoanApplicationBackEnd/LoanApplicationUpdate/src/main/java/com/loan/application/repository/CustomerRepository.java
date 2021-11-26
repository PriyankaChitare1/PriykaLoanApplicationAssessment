package com.loan.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.loan.application.module.Customer;

@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer,String>{
	
	List<Customer> findByEmailAndPassword(String email,String password);

}
