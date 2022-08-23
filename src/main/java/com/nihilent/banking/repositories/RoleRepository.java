package com.nihilent.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
	
	List<Role> findByRoleName(String roleName);

}
