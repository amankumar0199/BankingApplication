package com.Nagarro.customerManagement.exception;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException(String message) {
        super(message);
    }
}