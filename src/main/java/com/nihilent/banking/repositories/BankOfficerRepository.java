package com.nihilent.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.BankOfficer;
import com.nihilent.banking.entity.Role;
import com.nihilent.banking.entity.User;

@Repository
public interface BankOfficerRepository extends JpaRepository<BankOfficer,Integer>{
	List<BankOfficer> findByUser(User user);
}
