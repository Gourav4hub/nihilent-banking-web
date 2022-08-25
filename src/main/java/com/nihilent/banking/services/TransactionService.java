package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.AccountTransaction;
import com.nihilent.banking.repositories.TransactionRepository;
@Service
public class TransactionService implements BaseService<AccountTransaction>
{
	@Autowired
	private TransactionRepository accountTransactionRepository;
	
	@Override
	public AccountTransaction save(AccountTransaction ob) {
		try {
			AccountTransaction accountTransaction = accountTransactionRepository.save(ob);
			return accountTransaction;
		}catch(Exception ex) {
			System.out.println("AccountTransaction Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public AccountTransaction update(AccountTransaction ob) {
		try {
			AccountTransaction accountTransaction = accountTransactionRepository.save(ob);
			return accountTransaction;
		}catch(Exception ex) {
			System.out.println("AccountTransaction Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<AccountTransaction> list() {
		try {
			return accountTransactionRepository.findAll();
		}catch(Exception ex) {
			System.out.println("AccountTransaction List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public AccountTransaction get(int id) {
		try {
			Optional<AccountTransaction> op = accountTransactionRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("AccountTransaction Save Error : " + ex.getMessage());
			return null;
		}
	}
}
