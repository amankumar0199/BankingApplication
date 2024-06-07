package com.Nagarro.AccountManagement.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Nagarro.AccountManagement.entities.AccountModel;


@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>{
	AccountModel findByAccountNumber(String accountNumber);
	void deleteByAccountNumber(String accountNumber);
	List<AccountModel> findBycustomerId(Long customerId);
}


