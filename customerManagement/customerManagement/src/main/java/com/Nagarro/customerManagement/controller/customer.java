package com.Nagarro.customerManagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Nagarro.customerManagement.exception.CustomerNotFoundException;
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
		customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		}
	
	@GetMapping
	public List<customerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }
	
	
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
	public ResponseEntity<String> DeleteCustomer(@PathVariable Long id) {
	
		try {
			customerService.deleteCustomer(id);
			return ResponseEntity.ok("Customer removed");
		} catch (CustomerNotFoundException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	

	
	
	
	
}
