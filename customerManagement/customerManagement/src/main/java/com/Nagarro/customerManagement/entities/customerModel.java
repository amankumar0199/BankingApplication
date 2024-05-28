package com.Nagarro.customerManagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class customerModel{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerid;
	private String customerName;
	private String customerMob;
	private String customerAddr;
	
	public customerModel() {
		super();
	}
	public customerModel(Long customerid, String customerName, String customerMob, String customerAddr) {
		super();
		this.customerid = customerid;
		this.customerName = customerName;
		this.customerMob = customerMob;
		this.customerAddr = customerAddr;
	}




	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMob() {
		return customerMob;
	}
	public void setCustomerMob(String customerMob) {
		this.customerMob = customerMob;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customerName=" + customerName + ", customerMob=" + customerMob
				+ ", customerAddr=" + customerAddr + "]";
	}
	
	
}