package com.nihilent.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nihilent.banking.entity.SuperAdmin;
import com.nihilent.banking.entity.User;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin,Integer>{
	List<SuperAdmin> findByUsername(String superAdminname);
}
