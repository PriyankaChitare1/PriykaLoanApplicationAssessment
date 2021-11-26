package com.loan.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.module.Loan;
import com.loan.application.module.PaymentSchedule;
import com.loan.application.repository.CustomerRepository;
import com.loan.application.repository.LoanRepository;
import com.loan.application.repository.PaymentScheduleRepository;

@Service
public class PaymentService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	PaymentScheduleRepository paymentScheduleRepository;

	public Loan getLoanDetailsForPayment(String loanID) {
		
		return loanRepository.findById(loanID).get();
	}

	public List<PaymentSchedule> getPaymentScheduleByLoanId(String loanID) {
		// TODO Auto-generated method stub
		return paymentScheduleRepository.findByLoanId(loanID);
	}

	public PaymentSchedule updatePaymentStatus(String paymentId) {
		Optional<PaymentSchedule> paymentScheduleOptional = paymentScheduleRepository.findById(paymentId);
		PaymentSchedule paymentSchedule =  new PaymentSchedule();
		if(paymentScheduleOptional.isPresent()) {
			paymentSchedule = paymentScheduleOptional.get();
			paymentSchedule.setPaymentStatus("PAID");
		}
		
		return paymentScheduleRepository.save(paymentSchedule);
	}

}
