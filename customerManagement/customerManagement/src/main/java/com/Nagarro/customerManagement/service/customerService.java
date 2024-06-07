package com.Nagarro.customerManagement.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Nagarro.customerManagement.entities.AccountModel;
import com.Nagarro.customerManagement.entities.customerModel;
import com.Nagarro.customerManagement.repo.Customerrepository;

@Service
public class customerService {

	@Autowired
	private Customerrepository customerRepository;
	
    @Autowired
    private RestTemplate restTemplate;
	
	
	
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

//	public void deleteCustomer(Long id) {
//		customerRepository.deleteById(id);
//	}
	
	public Void deleteRelatedAccounts(Long customerId){
		return restTemplate.exchange("http://localhost:8082/accounts/" + customerId, HttpMethod.DELETE, null, Void.class).getBody();   

	}
		
	
	public void deleteCustomer(Long id) {
		deleteRelatedAccounts(id);
		
			
		customerRepository.deleteById(id);
	}


	
	
//	public ArrayList<customerModel> getCustomer();

}

