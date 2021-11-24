package com.loan.application.module;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Loan implements Cloneable{
	
	@Id
	private String loanId;
	private String customerId;
	private double loanAmount;
	private Date tradeDate;
	private Date startDate;
	private Date maturityDate;
	private int loanDuration;
	private String paymentFrequency;
	private int paymentSchedule;
	private float interestRate;
	private String PaymentTerm;
	private double projectedInterest;
	private boolean isPaid;
	
	//Default Constructor
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized Constructor
	public Loan(String loanId, String customerId, double loanAmount, Date tradeDate, Date startDate, Date maturityDate,
			int loanDuration, String paymentFrequency, int paymentSchedule, float interestRate, String paymentTerm,
			double projectedInterest, boolean isPaid) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.loanAmount = loanAmount;
		this.tradeDate = tradeDate;
		this.startDate = startDate;
		this.maturityDate = maturityDate;
		this.loanDuration = loanDuration;
		this.paymentFrequency = paymentFrequency;
		this.paymentSchedule = paymentSchedule;
		this.interestRate = interestRate;
		PaymentTerm = paymentTerm;
		this.projectedInterest = projectedInterest;
		this.isPaid = isPaid;
	}

	//Getter and Setter
	
	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public int getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	public int getPaymentSchedule() {
		return paymentSchedule;
	}

	public void setPaymentSchedule(int paymentSchedule) {
		this.paymentSchedule = paymentSchedule;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public String getPaymentTerm() {
		return PaymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		PaymentTerm = paymentTerm;
	}

	public double getProjectedInterest() {
		return projectedInterest;
	}

	public void setProjectedInterest(double projectedInterest) {
		this.projectedInterest = projectedInterest;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	
	//toString Method
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", customerId=" + customerId + ", loanAmount=" + loanAmount + ", tradeDate="
				+ tradeDate + ", startDate=" + startDate + ", maturityDate=" + maturityDate + ", loanDuration="
				+ loanDuration + ", paymentFrequency=" + paymentFrequency + ", paymentSchedule=" + paymentSchedule
				+ ", interestRate=" + interestRate + ", PaymentTerm=" + PaymentTerm + ", projectedInterest="
				+ projectedInterest + ", isPaid=" + isPaid + "]";
	}

	public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
	
	
	
}
