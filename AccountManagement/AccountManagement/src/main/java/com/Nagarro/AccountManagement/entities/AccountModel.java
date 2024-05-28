package com.Nagarro.AccountManagement.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AccountModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private String accountNumber;
	private Long customerId;
	private double accountBalance;
	private String accountStatus;
	private String branchId;
	
	
	public AccountModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AccountModel(String accountNumber, Long customerId, double accountBalance, String accountStatus,
			String branchId) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.accountBalance = accountBalance;
		this.accountStatus = accountStatus;
		this.branchId = branchId;
	}


	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double d) {
		this.accountBalance = d;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	

	@Override
	public String toString() {
		return "AccountModel [accountId=" + accountId + ", accountNumber=" + accountNumber + ", customerId="
				+ customerId + ", accountBalance=" + accountBalance + ", accountStatus=" + accountStatus + ", branchId="
				+ branchId + "]";
	}
	

}
