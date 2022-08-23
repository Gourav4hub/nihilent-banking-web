package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.Bank;
import com.nihilent.banking.repositories.BankRepository;
@Service
public class BankService implements BaseService<Bank>
{
	@Autowired
	private BankRepository bankRepository;
	
	@Override
	public Bank save(Bank ob) {
		try {
			Bank bank = bankRepository.save(ob);
			return bank;
		}catch(Exception ex) {
			System.out.println("Bank Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Bank update(Bank ob) {
		try {
			Bank bank = bankRepository.save(ob);
			return bank;
		}catch(Exception ex) {
			System.out.println("Bank Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Bank> list() {
		try {
			return bankRepository.findAll();
		}catch(Exception ex) {
			System.out.println("Bank List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Bank get(int id) {
		System.out.println("Bank id : " + id);
		try {
			Optional<Bank> op = bankRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("Bank get Error : " + ex.getMessage());
			return null;
		}
	}

}
