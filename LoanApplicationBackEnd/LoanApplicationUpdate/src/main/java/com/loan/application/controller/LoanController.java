package com.loan.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.application.module.Loan;
import com.loan.application.services.LoanService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loan/{customerId}")
	private List<Loan> getLoanList(@PathVariable("customerId") String customerId){
		return loanService.getLoanByCustomerId(customerId);
	}
	
	@PostMapping("/addloan")
	private Loan saveLoan(@RequestBody Loan loan) {
		return loanService.saveLoan(loan);
	}
	
	@PutMapping("/update-loanstatus/{laonId}")
	private Loan approvedLoan(@PathVariable("loanId") String LoanId) {
		return loanService.approvedLoan(LoanId);
	}

}
