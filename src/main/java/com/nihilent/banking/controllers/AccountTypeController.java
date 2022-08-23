package com.nihilent.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.banking.entity.AccountType;
import com.nihilent.banking.models.AccountTypeModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.AccountTypeService;

@RestController
@CrossOrigin
@RequestMapping("/api/acttype")
public class AccountTypeController 
{
	@Autowired
	private AccountTypeService accountTypeService;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveAccountType(@RequestBody AccountTypeModel  model)
	{
		AccountType accountType = accountTypeService.save(new AccountType(null, model.getTypeName()));
		if(accountType!=null)
			return ResponseEntity.ok(new ApiResponse(true, accountType, "AccountType Saved !"));
		else
			return ResponseEntity.ok(new ApiResponse(false, null, "AccountType Not Saved !"));
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listAccountTypes(){
		System.out.println("AccountTypes List");
		return ResponseEntity.ok(new ApiResponse(true, accountTypeService.list(), "AccountTypes"));
	}
}
