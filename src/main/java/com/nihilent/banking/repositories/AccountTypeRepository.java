package com.nihilent.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.AccountType;
import com.nihilent.banking.entity.Role;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer>{

}
