package com.Nagarro.AccountManagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Nagarro.AccountManagement.entities.AccountModel;
import com.Nagarro.AccountManagement.entities.customerModel;
import com.Nagarro.AccountManagement.exception.CustomerNotFoundException;
import com.Nagarro.AccountManagement.exception.InsufficientFundsException;
import com.Nagarro.AccountManagement.repo.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(AccountService.class);
    
    
    public boolean isCustomerExists(Long customerId) {
        ResponseEntity<customerModel> responseEntity = restTemplate.getForEntity("http://localhost:8083/customers/" + customerId, customerModel.class);
        logger.info("", responseEntity);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }
    
    
    public void openAccount(AccountModel account) {
        if (isCustomerExists(account.getCustomerId())) {
            accountRepository.save(account);
        } else {
            throw new CustomerNotFoundException("Customer does not exist");
        }
    }
	
	public void addMoney(String accountNumber, double amount) {
        AccountModel account = accountRepository.findByAccountNumber(accountNumber);

        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }

        account.setAccountBalance(account.getAccountBalance() + amount);
        accountRepository.save(account);
    }
	
	

	
	
	public void withdraw(String accountNumber, double amount) {
		AccountModel account = accountRepository.findByAccountNumber(accountNumber);
		
		if(account == null) {
			throw new IllegalArgumentException("Account not found");
		}
		
		if(account.getAccountBalance()< amount) {
			throw new InsufficientFundsException("Insufficient funds");
		}
		
		account.setAccountBalance(account.getAccountBalance() - amount);
        accountRepository.save(account);
			
	}


	public AccountModel getDetails(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}


	public boolean deleteAccount(String accountNumber) {
		AccountModel account = accountRepository.findByAccountNumber(accountNumber);
		if(account != null) {
			accountRepository.deleteByAccountNumber(accountNumber);
			return true;
		}
		else {
			return false;
		}
	}


	public void deleteAccountbyID(Long id) {
		accountRepository.deleteById(id);
	}


	public boolean removeAccounts(Long customerId) {
		List<AccountModel> accounts = accountRepository.findBycustomerId(customerId);
		for(AccountModel account : accounts) {
			Long accountId = account.getAccountId();
			accountRepository.deleteById(accountId);
		}
		return true;
		
	}

}
