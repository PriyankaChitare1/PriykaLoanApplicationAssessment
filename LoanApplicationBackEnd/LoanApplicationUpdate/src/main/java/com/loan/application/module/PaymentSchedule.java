package com.loan.application.module;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PaymentSchedule {
	
	@Id
	private String paymentId;
	private String loanId;
	private Date paymentDate;
	private double principal;
	private double projectInterest;
	private String paymentStatus;
	private double paymentAmount;
	
	// Default Constructor
	public PaymentSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// parameterized Constructor
	public PaymentSchedule(String paymentId, String loanId, Date paymentDate, double principal, double projectInterest,
			String paymentStatus, double paymentAmount) {
		super();
		this.paymentId = paymentId;
		this.loanId = loanId;
		this.paymentDate = paymentDate;
		this.principal = principal;
		this.projectInterest = projectInterest;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
	}
	
	// Getters and setters

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getProjectInterest() {
		return projectInterest;
	}

	public void setProjectInterest(double projectInterest) {
		this.projectInterest = projectInterest;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	// tostring Method
	@Override
	public String toString() {
		return "PaymentSchedule [paymentId=" + paymentId + ", loanId=" + loanId + ", paymentDate=" + paymentDate
				+ ", principal=" + principal + ", projectInterest=" + projectInterest + ", paymentStatus="
				+ paymentStatus + ", paymentAmount=" + paymentAmount + "]";
	}

	

	
	
	
	
	
}
