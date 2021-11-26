package com.loan.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan.application.module.Loan;
import com.loan.application.module.PaymentSchedule;
import com.loan.application.services.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/loan-details/{loanId}")
	private Loan getLoanDetailsForPayment(@PathVariable("loanId") String loanId ) {
		return paymentService.getLoanDetailsForPayment(loanId);
	}
	
	@GetMapping("/loan/payment-schedule/{loanId}")
	private List<PaymentSchedule> getPaymentSchedule(@PathVariable("loanId") String loanId){
		return paymentService.getPaymentScheduleByLoanId(loanId);
		
	}
	
	@PutMapping("/update-payment/{paymentId}")
	private PaymentSchedule updatePaymentStatus(@PathVariable("paymentId") String paymentId) {
		 return paymentService.updatePaymentStatus(paymentId);
	}

}
