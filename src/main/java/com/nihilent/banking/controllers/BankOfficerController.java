package com.nihilent.banking.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.banking.entity.Bank;
import com.nihilent.banking.entity.BankOfficer;
import com.nihilent.banking.entity.Role;
import com.nihilent.banking.entity.BankUser;
import com.nihilent.banking.models.BankOfficerModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.BankOfficerService;
import com.nihilent.banking.services.BankService;
import com.nihilent.banking.services.RoleService;
import com.nihilent.banking.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/bankOfficer")
public class BankOfficerController 
{
	@Autowired
	private BankOfficerService bankOfficerService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BankService bankService;
	
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveBankOfficer(@RequestBody BankOfficerModel  model)
	{		
		System.out.println("Model : " + model);
		Role role = roleService.getByName("ROLE_BANK_OFFICER");
		Bank bank = bankService.get(model.getBankId());
		System.out.println("Role : " + role);
		System.out.println("Bank : " + bank);
		if(role!=null) 
		{
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			BankUser user = new BankUser(null, model.getUserName(), model.getPassword(), model.getEmail(), roles);
			user = userService.save(user);
			
			BankOfficer newofficer = new BankOfficer(null, model.getOfficerName(), model.getOfficerPhone(), bank, user);
			newofficer = bankOfficerService.save(newofficer);
			if(newofficer!=null)
				return ResponseEntity.ok(new ApiResponse(true, newofficer, "Bank Officer Saved !"));
			else
				return ResponseEntity.ok(new ApiResponse(false, null, "Bank Officer Not Saved !"));
		}else {
			return ResponseEntity.ok(new ApiResponse(false, null, "Bank Officer Not Saved !"));
		}		
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listBankOfficers(){
		System.out.println("BankOfficers List");
		return ResponseEntity.ok(new ApiResponse(true, bankOfficerService.list(), "BankOfficers"));
	}
}
