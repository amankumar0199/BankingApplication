package com.Nagarro.AccountManagement.repo;
import org.springframework.stereotype.Repository;

import com.Nagarro.AccountManagement.entities.AccountModel;
import com.google.common.base.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>{
	AccountModel findByAccountNumber(String accountNumber);
	void deleteByAccountNumber(String accountNumber);
}


