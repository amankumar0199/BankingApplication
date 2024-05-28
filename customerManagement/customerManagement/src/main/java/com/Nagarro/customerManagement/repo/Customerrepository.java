package com.Nagarro.customerManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nagarro.customerManagement.entities.customerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface Customerrepository extends JpaRepository<customerModel, Long>{

}
