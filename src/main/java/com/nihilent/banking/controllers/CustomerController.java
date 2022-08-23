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
import com.nihilent.banking.entity.Customer;
import com.nihilent.banking.entity.Role;
import com.nihilent.banking.entity.BankUser;
import com.nihilent.banking.models.CustomerModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.CustomerService;
import com.nihilent.banking.services.BankOfficerService;
import com.nihilent.banking.services.BankService;
import com.nihilent.banking.services.RoleService;
import com.nihilent.banking.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BankService bankService;
	@Autowired
	private BankOfficerService bankOfficerService;
	
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> saveCustomer(@RequestBody CustomerModel  model)
	{		
		System.out.println("Model : " + model);
		BankUser loginUser = userService.getByName(model.getOfficerId());
		BankOfficer officer = bankOfficerService.getByUser(loginUser);
		
		Role role = roleService.getByName("ROLE_BANK_CUSTOMER");
		Bank bank = officer.getBank();
		
		System.out.println("Role : " + role);
		System.out.println("Bank : " + bank);
		if(role!=null) 
		{
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			BankUser user = new BankUser(null, model.getUserName(), model.getPassword(), model.getEmail(), roles);
			user = userService.save(user);
			
			String upi = bank.getBankName().substring(0, 3)+user.getUserId();
			Customer customer = new Customer(null, model.getCustomerName(), upi, model.getCustomerPhone(), bank, user);
			
			customer = customerService.save(customer);
			if(customer!=null)
				return ResponseEntity.ok(new ApiResponse(true, customer, "customer Saved !"));
			else
				return ResponseEntity.ok(new ApiResponse(false, null, "customer Not Saved !"));
		}else {
			return ResponseEntity.ok(new ApiResponse(false, null, "customer Not Saved !"));
		}		
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> listCustomers(){
		System.out.println("Customers List");
		return ResponseEntity.ok(new ApiResponse(true, customerService.list(), "Customers"));
	}
}
