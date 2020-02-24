package com.capg.corejava.wallet.beans;

public class Model {
	private String password;
	private String customerName;
	private double accountBalance;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Model() {
		super();
	}

	public Model(String password, String customerName, double accountBalance) {
		super();
		this.password = password;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public String getPassword() {
		return password;

	}
}