package com.nihilent.banking.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.BankUser;

@Repository
public interface UserRepository extends JpaRepository<BankUser,Integer>{
	Optional<BankUser> findByUsername(String username);
}
