package com.nihilent.banking.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.Employee;
import com.nihilent.banking.repositories.EmployeeRepository;

@Service
public class EmployeeService implements BaseService<Employee>
{
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public boolean save(Employee ob) {
		try {
			ob.setCreatedAt(LocalDate.now());
			ob.setUpdatedAt(LocalDate.now());
			empRepo.save(ob);
			return true;
		}catch(Exception ex) {
			System.err.println("Employee Save Error : " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Employee ob) {
		try {
			ob.setUpdatedAt(LocalDate.now());
			empRepo.save(ob);
			return true;
		}catch(Exception ex) {
			System.err.println("Employee Update Error : " + ex.getMessage());
			return false;
		}
	}

	@Override
	public List<Employee> list() {
		try {
			return empRepo.findAll();
		}catch(Exception ex) {
			System.err.println("Employee List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Employee get(int id) {
		try {
			Optional<Employee> optional =  empRepo.findById(id);
			if(optional.isPresent())
				return optional.get();
			else
				return null;
		}catch(Exception ex) {
			System.err.println("Employee Get Error : " + ex.getMessage());
			return null;
		}
	}

}
