package com.nihilent.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.Customer;
import com.nihilent.banking.entity.Role;
import com.nihilent.banking.entity.BankUser;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	List<Customer> findByUser(BankUser user);
}
