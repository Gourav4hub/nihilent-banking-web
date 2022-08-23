package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.Customer;
import com.nihilent.banking.entity.BankUser;
import com.nihilent.banking.repositories.CustomerRepository;

@Service
public class CustomerService implements BaseService<Customer>
{
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Session giveSession() {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		Session ss = sessionFactory.openSession();
		return ss;
	}
	
	@Override
	public Customer save(Customer ob) {
		try {
			Customer customer = customerRepository.save(ob);
			return customer;
		}catch(Exception ex) {
			System.out.println("Customer Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Customer update(Customer ob) {
		try {
			Customer customer = customerRepository.save(ob);
			return customer;
		}catch(Exception ex) {
			System.out.println("Customer Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Customer> list() {
		try {
			return customerRepository.findAll();
		}catch(Exception ex) {
			System.out.println("Customer List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Customer get(int id) {
		try {
			Optional<Customer> op = customerRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("Customer Save Error : " + ex.getMessage());
			return null;
		}
	}

	public Customer getByUser(BankUser loginUser) {
		
		List<Customer> officers = customerRepository.findByUser(loginUser);
		
		 if(officers.size()==0)
			 return null;
		 else
			 return officers.get(0);
	}

}
