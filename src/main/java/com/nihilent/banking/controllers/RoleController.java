package com.nihilent.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.banking.entity.Role;
import com.nihilent.banking.models.RoleModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.RoleService;

@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleController 
{
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveRole(@RequestBody RoleModel  model)
	{
		Role role = roleService.save(new Role(null, model.getRoleName()));
		if(role!=null)
			return ResponseEntity.ok(new ApiResponse(true, role, "Role Saved !"));
		else
			return ResponseEntity.ok(new ApiResponse(false, null, "Role Not Saved !"));
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listRoles(){
		System.out.println("Roles List");
		return ResponseEntity.ok(new ApiResponse(true, roleService.list(), "Roles"));
	}
}
