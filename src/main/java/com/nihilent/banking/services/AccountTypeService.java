package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.AccountType;
import com.nihilent.banking.repositories.AccountTypeRepository;
@Service
public class AccountTypeService implements BaseService<AccountType>
{
	@Autowired
	private AccountTypeRepository accountTypeRepository;
	
	@Override
	public AccountType save(AccountType ob) {
		try {
			AccountType accountType = accountTypeRepository.save(ob);
			return accountType;
		}catch(Exception ex) {
			System.out.println("AccountType Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public AccountType update(AccountType ob) {
		try {
			AccountType accountType = accountTypeRepository.save(ob);
			return accountType;
		}catch(Exception ex) {
			System.out.println("AccountType Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<AccountType> list() {
		try {
			return accountTypeRepository.findAll();
		}catch(Exception ex) {
			System.out.println("AccountType List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public AccountType get(int id) {
		try {
			Optional<AccountType> op = accountTypeRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("AccountType Save Error : " + ex.getMessage());
			return null;
		}
	}

}
