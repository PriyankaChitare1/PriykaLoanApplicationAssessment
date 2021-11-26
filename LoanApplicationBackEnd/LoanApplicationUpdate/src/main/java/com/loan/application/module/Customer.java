package com.loan.application.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	private String customerId;
	private String name;
	private long accountNumber;
	private String address;
	private String email;
	private int phone;
	private String password;
	
	// Default Constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized  Constructor
	public Customer(String customerId, String name, long accountNumber, String address, String email, int phone,
			String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	//Getter and Setter

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// generate tostring method

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", accountNumber=" + accountNumber
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}
