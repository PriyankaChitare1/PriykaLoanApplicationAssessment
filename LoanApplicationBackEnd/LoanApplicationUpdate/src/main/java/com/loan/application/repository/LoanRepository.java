package com.loan.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.loan.application.module.Loan;

@EnableJpaRepositories

public interface LoanRepository extends JpaRepository<Loan , String>{
	
	List<Loan> findByCustomerId(String customerId);
	

}
