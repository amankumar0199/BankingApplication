package com.Nagarro.customerManagement.controller;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import com.Nagarro.customerManagement.entities.customerModel;
import com.Nagarro.customerManagement.service.customerService;

@RestController
@RequestMapping("/customers")
public class customer{
	
	@Autowired
	customerService customerService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<customerModel> addCustomer(@RequestBody customerModel customer) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		}
	
	@GetMapping
	public List<customerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }
	
//	@GetMapping("/{id1}")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity add1Customer(@RequestBody customerModel customer) {
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
//		}
	
	@GetMapping("/{id}")
	public ResponseEntity<customerModel> getCustomer(@PathVariable Long id) {
		customerModel customer = customerService.getCustomerById(id);
        if (customer != null) {
        	return ResponseEntity.status(HttpStatus.OK).body(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customer);
        }	
	}
	
	@DeleteMapping("/{id}")
	public void DeleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}

	
	
	
	
}
