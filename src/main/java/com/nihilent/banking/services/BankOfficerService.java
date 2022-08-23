package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.BankOfficer;
import com.nihilent.banking.entity.User;
import com.nihilent.banking.repositories.BankOfficerRepository;

@Service
public class BankOfficerService implements BaseService<BankOfficer>
{
	@Autowired
	private BankOfficerRepository bankOfficerRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session giveSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session ss = sessionFactory.openSession();
		return ss;
	}
	
	@Override
	public BankOfficer save(BankOfficer ob) {
		try {
			BankOfficer bankOfficer = bankOfficerRepository.save(ob);
			return bankOfficer;
		}catch(Exception ex) {
			System.out.println("BankOfficer Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public BankOfficer update(BankOfficer ob) {
		try {
			BankOfficer bankOfficer = bankOfficerRepository.save(ob);
			return bankOfficer;
		}catch(Exception ex) {
			System.out.println("BankOfficer Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<BankOfficer> list() {
		try {
			return bankOfficerRepository.findAll();
		}catch(Exception ex) {
			System.out.println("BankOfficer List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public BankOfficer get(int id) {
		try {
			Optional<BankOfficer> op = bankOfficerRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("BankOfficer Save Error : " + ex.getMessage());
			return null;
		}
	}

	public BankOfficer getByUser(User loginUser) {
		
		List<BankOfficer> officers = bankOfficerRepository.findByUser(loginUser);
		
		 if(officers.size()==0)
			 return null;
		 else
			 return officers.get(0);
	}

}
