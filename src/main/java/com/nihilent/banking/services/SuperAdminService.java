package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.SuperAdmin;
import com.nihilent.banking.repositories.SuperAdminRepository;

@Service
public class SuperAdminService implements BaseService<SuperAdmin>
{
	@Autowired
	private SuperAdminRepository usuperAdminRepository;
	
	@Override
	public SuperAdmin save(SuperAdmin ob) {
		try {
			SuperAdmin SuperAdmin = usuperAdminRepository.save(ob);
			return SuperAdmin;
		}catch(Exception ex) {
			System.out.println("SuperAdmin Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public SuperAdmin update(SuperAdmin ob) {
		try {
			SuperAdmin SuperAdmin = usuperAdminRepository.save(ob);
			return SuperAdmin;
		}catch(Exception ex) {
			System.out.println("SuperAdmin Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<SuperAdmin> list() {
		try {
			return usuperAdminRepository.findAll();
		}catch(Exception ex) {
			System.out.println("SuperAdmin List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public SuperAdmin get(int id) {
		try {
			Optional<SuperAdmin> op = usuperAdminRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("SuperAdmin Save Error : " + ex.getMessage());
			return null;
		}
	}
	

	public List<SuperAdmin> getByName(String name) {
		try {
			List<SuperAdmin> list = usuperAdminRepository.findByUsername(name);
			return list;
		}catch(Exception ex) {
			System.out.println("SuperAdmin GetByName Error : " + ex.getMessage());
			return null;
		}
	}

}
