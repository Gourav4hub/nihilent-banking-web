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

import com.nihilent.banking.entity.AccountType;
import com.nihilent.banking.entity.Bank;
import com.nihilent.banking.models.BankModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.AccountTypeService;
import com.nihilent.banking.services.BankService;

@RestController
@CrossOrigin
@RequestMapping("/api/bank")
public class BankController 
{
	@Autowired
	private BankService bankService;
	@Autowired
	private AccountTypeService accountTypeService;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveBank(@RequestBody BankModel  model)
	{
		System.out.println(model);
		Set<AccountType> types = new HashSet<>();
		for(Integer id : model.getTypes()) {
			AccountType ob =  accountTypeService.get(id);
			if(ob!=null)
				types.add(ob);
		}
		System.out.println(types);
		Bank bank = new Bank(model);
		bank.setAccountTypes(types);
		
		bank = bankService.save(bank);
		if(bank!=null)
			return ResponseEntity.ok(new ApiResponse(true, bank, "Bank Saved !"));
		else
			return ResponseEntity.ok(new ApiResponse(false, null, "Bank Not Saved !"));
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listBanks(){
		System.out.println("Banks List");
		return ResponseEntity.ok(new ApiResponse(true, bankService.list(), "Banks"));
	}
}
