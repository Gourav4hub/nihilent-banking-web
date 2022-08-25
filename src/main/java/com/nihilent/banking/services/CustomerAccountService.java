package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.CustomerAccount;
import com.nihilent.banking.repositories.CustomerAccountRepository;
@Service
public class CustomerAccountService implements BaseService<CustomerAccount>
{
	@Autowired
	private CustomerAccountRepository customerAccountRepository;
	
	@Override
	public CustomerAccount save(CustomerAccount ob) {
		try {
			CustomerAccount customerAccount = customerAccountRepository.save(ob);
			return customerAccount;
		}catch(Exception ex) {
			System.out.println("CustomerAccount Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public CustomerAccount update(CustomerAccount ob) {
		try {
			CustomerAccount customerAccount = customerAccountRepository.save(ob);
			return customerAccount;
		}catch(Exception ex) {
			System.out.println("CustomerAccount Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<CustomerAccount> list() {
		try {
			return customerAccountRepository.findAll();
		}catch(Exception ex) {
			System.out.println("CustomerAccount List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public CustomerAccount get(int id) {
		try {
			Optional<CustomerAccount> op = customerAccountRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("CustomerAccount Save Error : " + ex.getMessage());
			return null;
		}
	}
}
