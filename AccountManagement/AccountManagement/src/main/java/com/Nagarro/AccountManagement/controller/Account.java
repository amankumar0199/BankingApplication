package com.Nagarro.AccountManagement.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Nagarro.AccountManagement.entities.AccountModel;
import com.Nagarro.AccountManagement.service.AccountService;
import com.Nagarro.AccountManagement.exception.InsufficientFundsException;
import com.Nagarro.AccountManagement.exception.CustomerNotFoundException;



@RestController
@RequestMapping("/accounts")
public class Account {
	@Autowired
	AccountService accountService;
	
	
	@PostMapping("/openAccount")
	public ResponseEntity<String> openAccount(@RequestBody AccountModel account){
		try {
			accountService.openAccount(account);
			return ResponseEntity.ok("Account opened successfully");
		} catch (CustomerNotFoundException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
    @PostMapping("/addMoney")
    public ResponseEntity<String> addMoney(@RequestParam String accountNumber, @RequestParam double amount) {
        try {
            accountService.addMoney(accountNumber, amount);
            return ResponseEntity.ok("Money added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
	
//	withdraw money
	/*
	 * 1. send account
	 * 2. api check if account is available
	 * 3. 	if amount is available
	 * 4. return amount subtract from total
	 * 5. update account balance
	 * 
	 * in request body we will send account number, withdrawal amount, 
	 * */
	@PostMapping("/withdraw")
	public ResponseEntity<String> withdrawAmount(@RequestParam String accountNumber, @RequestParam double amount ){
        try {
            accountService.withdraw(accountNumber, amount);
            return ResponseEntity.ok("Withdrawal successful");
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	}
	

	@GetMapping("/getDetail")
	public ResponseEntity<AccountModel> getAccountDetail(@RequestParam String accountNumber){
		AccountModel account = accountService.getDetails(accountNumber);
		return ResponseEntity.status(HttpStatus.SC_OK).body(account);
	}
	

	@DeleteMapping("/removeAccount")
	public ResponseEntity<String> deleteAccount(@RequestParam String accountNumber){
		
		boolean isDeleted = accountService.deleteAccount(accountNumber);
		if(isDeleted) {
			return ResponseEntity.status(HttpStatus.SC_OK).body("account removed");
		}
		else {
			return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("account not found");
		}
	}
	
	
	
}
