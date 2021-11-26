package com.loan.application.services;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.module.Loan;
import com.loan.application.module.PaymentSchedule;
import com.loan.application.repository.CustomerRepository;
import com.loan.application.repository.LoanRepository;
import com.loan.application.repository.PaymentScheduleRepository;

@Service
public class LoanService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	PaymentScheduleRepository payementScheduleRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(LoanService.class);
	
	private String generateKey(String prefix) {
		String key =UUID.randomUUID().toString().split("-")[0];
		return prefix + key ;
	}

	public List<Loan> getLoanByCustomerId(String customerId) {
		List <Loan> loans = new ArrayList<Loan>();
		loanRepository.findByCustomerId(customerId).forEach(loan -> loans.add(loan));
		logger.info("Here we are getting Loan Details By CystomerId",customerId);
		return loans;
	}

	public Loan saveLoan(Loan loan) {
		loan.setPaid(false);
		loan.setLoanId(generateKey("FINZ"));
		try {
			createPaymentSchedule((Loan) loan.clone());
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		logger.info("Here Loan is Created for the Customer",loan);
		return loanRepository.save(loan);
	}

	private void createPaymentSchedule(Loan loan) {
        String paymentTerm = loan.getPaymentTerm();
        if(paymentTerm.contains("Interest Only")) {
        	createInterestOnlySchedule(loan);
        	
        }else if(paymentTerm.contains("Even Principal")) {
        	createEvenPrincipalSchedule(loan);
        }
	}

	private void createEvenPrincipalSchedule(Loan loan) {
		List<PaymentSchedule> paymentScheduleList = new ArrayList<PaymentSchedule>();
		double perPaymentPrincipal = loan.getLoanAmount()/loan.getPaymentSchedule();
		for(int j =1 ; j<= loan.getPaymentSchedule();j++) {
			PaymentSchedule paymentSchedule = new PaymentSchedule();
			paymentSchedule.setPaymentId(generateKey("PAY"));
			paymentSchedule.setLoanId(loan.getLoanId());
			paymentSchedule.setPaymentDate(calculatePaymentDate(loan, loan.getPaymentFrequency()));
			paymentSchedule.setPrincipal(loan.getLoanAmount());
			paymentSchedule.setProjectInterest(calculateInterest(loan,perPaymentPrincipal));
			paymentSchedule.setPaymentStatus("PROJECTED");
			paymentSchedule.setPaymentAmount(paymentSchedule.getProjectInterest() + perPaymentPrincipal);
			paymentScheduleList.add(paymentSchedule);
		}
		logger.info("Here we are creating Even Principal Schedule ", loan);
		payementScheduleRepository.saveAll(paymentScheduleList);
		
	}

	private double calculateInterest(Loan loan, double perPaymentPrincipal) {
		double paymentSchedule = loan.getPaymentSchedule();
		double principal = loan.getLoanAmount();
		double years = loan.getLoanAmount();
		double interestRate = loan.getInterestRate();
		double interestAmount = (double)((principal * (years / paymentSchedule) * interestRate)/100);
		principal = principal - perPaymentPrincipal;
		loan.setLoanAmount(principal);
		
		return interestAmount;
	}

	private Date calculatePaymentDate(Loan loan, String paymentFrequency) {
		Date paymentDate = null;
		SimpleDateFormat formatte = new SimpleDateFormat("dd-MM-yyyy");
		/*Date date = null;
		try {
			date = formatte.parse(loan.getStartDate());
			
		}catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		Calendar paymentDateCalendar = Calendar.getInstance();
		paymentDateCalendar.setTime(paymentDate);
		switch (paymentFrequency) {
		case "Monthly":{
			paymentDateCalendar.add(Calendar.MONTH, 1);
			/*paymentDate = "" + paymentDateCalendar.get(Calendar.DATE) + "-"
					+(paymentDateCalendar.get(Calendar.MONTH)+1) + "-" + paymentDateCalendar.get(Calendar.YEAR);*/
			//loan.setStartDate(paymentDate);
			break;
		}
		
		case "Quarterly":{
			paymentDateCalendar.add(Calendar.MONTH, 3);
			/*paymentDate = ("" + paymentDateCalendar.get(Calendar.DATE)+ "-"
					+ (paymentDateCalendar.get(Calendar.MONTH)+1) + "-" + paymentDateCalendar.get(Calendar.YEAR));*/
			//loan.setStartDate(paymentDate);
			break;
		}
		case "Half Yearly" : {
			paymentDateCalendar.add(Calendar.MONTH, 6);
			/*paymentDate = "" + paymentDateCalendar.get(Calendar.DATE)+ "-"
					+(paymentDateCalendar.get(Calendar.MONTH));*/
			//loan.setStartDate(paymentDate);
			break;
		}
		}
		
		//paymentDate = convertDateFormat(paymentDate);
		loan.setStartDate(paymentDate);
		return paymentDate;
	}

	/*private Date convertDateFormat(Date paymentDate) {
		if(paymentDate.charAt(1)== '-') {
			paymentDate = "0" + paymentDate;
		}
		if(paymentDate.charAt(4) == '-') {
			paymentDate = paymentDate.substring(0,3) + "0" + paymentDate.substring(3);
		}
		return paymentDate;
	}*/

	private void createInterestOnlySchedule(Loan loan) {
       List <PaymentSchedule> paymentScheduleList = new ArrayList<PaymentSchedule>();
       double netPrincipal = loan.getLoanAmount();
       double perPaymentPrincipal = loan.getLoanAmount() / loan.getPaymentSchedule();
       for(int i = 1 ; i<=loan.getPaymentSchedule();i++) {
    	   PaymentSchedule paymentSchedule = new PaymentSchedule();
    	   paymentSchedule.setPaymentId(generateKey("PAY"));
    	   paymentSchedule.setLoanId(loan.getLoanId());
    	   paymentSchedule.setPaymentDate(calculatePaymentDate(loan, loan.getPaymentFrequency()));
    	   paymentSchedule.setProjectInterest(calculateInterest(loan,perPaymentPrincipal));
    	   if(i == loan.getPaymentSchedule()) {
    		   paymentSchedule.setPrincipal(netPrincipal);
    		   paymentSchedule.setPaymentAmount((paymentSchedule.getProjectInterest()) + (netPrincipal));
    		}else {
    			 paymentSchedule.setPrincipal(0);
    			 paymentSchedule.setPaymentAmount(paymentSchedule.getProjectInterest());
    			 
    		}
    	   
    	   paymentSchedule.setPaymentStatus("PROJECTED");
    	   paymentScheduleList.add(paymentSchedule);
    	   
       }
       logger.info("Here we are creating Interest Only Amount for loan ",loan);
       payementScheduleRepository.saveAll(paymentScheduleList);
       
	}

	public Loan approvedLoan(String loanId) {
		Optional <Loan> loanapprovedOptional= loanRepository.findById(loanId);
		Loan loan = new Loan();
		if(loanapprovedOptional.isPresent()) {
			loan = loanapprovedOptional.get();
			loan.setPaid(true);
		}
		logger.info("Approved Loan Status", loanId);
		
		return loanRepository.save(loan);
	}

}
