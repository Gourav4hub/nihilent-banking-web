package com.nihilent.banking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.Role;
import com.nihilent.banking.repositories.RoleRepository;
@Service
public class RoleService implements BaseService<Role>
{
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role save(Role ob) {
		try {
			Role role = roleRepository.save(ob);
			return role;
		}catch(Exception ex) {
			System.out.println("Role Save Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Role update(Role ob) {
		try {
			Role role = roleRepository.save(ob);
			return role;
		}catch(Exception ex) {
			System.out.println("Role Update Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Role> list() {
		try {
			return roleRepository.findAll();
		}catch(Exception ex) {
			System.out.println("Role List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public Role get(int id) {
		try {
			Optional<Role> op = roleRepository.findById(id);
			if(op.isPresent())
				return op.get();
			else
				return null;
		}catch(Exception ex) {
			System.out.println("Role Save Error : " + ex.getMessage());
			return null;
		}
	}

	public Role getByName(String string) {
		List<Role> roles =  roleRepository.findByRoleName(string);
		if(roles.size()>0)
			return roles.get(0);
		else
			return null;
	}

}
