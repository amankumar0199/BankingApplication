package com.Nagarro.customerManagement.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Nagarro.customerManagement.entities.customerModel;
import com.Nagarro.customerManagement.repo.Customerrepository;
import org.springframework.stereotype.Service;

@Service
public class customerService {

	@Autowired
	private Customerrepository customerRepository;
	
	
	
	public customerModel addCustomer(customerModel customer) {         
		return customerRepository.save(customer);
		
		}
	
	public List<customerModel> getAllCustomers() {         
		return customerRepository.findAll();
		
		}

	public customerModel getCustomerById(Long id) {
		Optional<customerModel> customer = customerRepository.findById(id);
		return customer.orElse(null);
		
		
		
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}


	
	
//	public ArrayList<customerModel> getCustomer();

}

