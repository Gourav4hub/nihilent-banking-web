package com.nihilent.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.Bank;
import com.nihilent.banking.entity.Role;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer>{

}
