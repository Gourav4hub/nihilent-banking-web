package com.nihilent.banking.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.banking.entity.AccountTransaction;
import com.nihilent.banking.entity.AccountType;
import com.nihilent.banking.entity.Bank;
import com.nihilent.banking.entity.BankOfficer;
import com.nihilent.banking.entity.Customer;
import com.nihilent.banking.entity.CustomerAccount;
import com.nihilent.banking.entity.Role;
import com.nihilent.banking.entity.BankUser;
import com.nihilent.banking.models.AccountModel;
import com.nihilent.banking.models.CustomerModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.CustomerService;
import com.nihilent.banking.services.AccountTypeService;
import com.nihilent.banking.services.BankOfficerService;
import com.nihilent.banking.services.BankService;
import com.nihilent.banking.services.CustomerAccountService;
import com.nihilent.banking.services.RoleService;
import com.nihilent.banking.services.TransactionService;
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
	@Autowired
	private AccountTypeService typeService;
	@Autowired
	private CustomerAccountService accountService;
	@Autowired
	private TransactionService transactionService;
	
	public int gen() {
	    Random r = new Random( System.currentTimeMillis() );
	    return 10000 + r.nextInt(20000);
	}
	@PostMapping("/addAccount")
	public ResponseEntity<ApiResponse> addCustomerAccount(@RequestBody AccountModel model)
	{
		Customer customer = customerService.get(model.getCustomer());
		if(customer!=null)
		{
			Long accountNumber = Long.parseLong(gen()+""+customer.getCustomerId());
			AccountType accountType = typeService.get(model.getAccountType());
			if(accountType!=null)
			{
			CustomerAccount account = new CustomerAccount(null, accountNumber, accountType, 
					model.getBalance(), model.getPreDayLimit(), model.getPerTransactionLimit());
			accountService.save(account);
			
			customer.setAccount(account);
			customerService.save(customer);
			return ResponseEntity.ok(new ApiResponse(true, customer, "Account Saved !"));
			}else
				return ResponseEntity.ok(new ApiResponse(false, null, "Account Type Not Found ! "));
		}else
			return ResponseEntity.ok(new ApiResponse(false, null, "Customer Not Found ! "));
	}
	
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
			Customer customer = new Customer(null, model.getCustomerName(), upi, model.getCustomerPhone(), bank, user,null);
			
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
	
	@PostMapping("/getByUserName")
	public ResponseEntity<ApiResponse> getByUserName(@RequestBody HashMap<String, String> data)
	{
		BankUser user = userService.getByName(data.get("name"));
		if(user!=null) {
			Customer customer =  customerService.getByUser(user);
			if(customer!=null)
				return ResponseEntity.ok(new ApiResponse(true, customer, "Customer"));
			else
				return ResponseEntity.ok(new ApiResponse(false, null, "Customer Not Found !"));
				
		}else
			return ResponseEntity.ok(new ApiResponse(false, null, "User Not Found !"));
		
	}
	
	@PostMapping("/getByUpi")
	public ResponseEntity<ApiResponse> getByUpi(@RequestBody HashMap<String, String> data)
	{
		
			Customer customer =  customerService.getByUPI(data.get("upi"));
			if(customer!=null)
				if(customer.getAccount()!=null)
					return ResponseEntity.ok(new ApiResponse(true, customer, "UPI Found "));
				else
					return ResponseEntity.ok(new ApiResponse(false, null, "No Account Available !"));
			else
				return ResponseEntity.ok(new ApiResponse(false, null, "UPI Not Found !"));
		
	}
	
	@PostMapping("/sendamount")
	public ResponseEntity<ApiResponse> sendAmount(@RequestBody HashMap<String, String> data)
	{
		Float amount = Float.parseFloat(data.get("amount"));
		String upi = data.get("upi");
		String username = data.get("username");
		String description = data.get("description");
		
		Customer receiver =  customerService.getByUPI(upi);
		
		BankUser user =userService.getByName(username);
		Customer sender =  customerService.getByUser(user);
		
		AccountTransaction transaction = new AccountTransaction(null, amount, new Date(), sender, receiver, description);		
		transactionService.save(transaction);
		
		CustomerAccount senderAccount = sender.getAccount();
		senderAccount.setBalance(senderAccount.getBalance()-amount);
		accountService.save(senderAccount);
		
		CustomerAccount receiverAccount = receiver.getAccount();
		receiverAccount.setBalance(receiverAccount.getBalance()+amount);
		accountService.save(receiverAccount);	
		
		
		return ResponseEntity.ok(new ApiResponse(true, null, "Transaction Done !"));
	}
	
	@PostMapping("/getTransactions")
	public ResponseEntity<ApiResponse> getTransactions(@RequestBody HashMap<String, String> data)
	{
		BankUser user = userService.getByName(data.get("name"));
		if(user!=null) {
			Customer customer =  customerService.getByUser(user);
			if(customer!=null)
				return ResponseEntity.ok(new ApiResponse(true, customerService.getTransactions(customer), "Customer Transactions"));
			else
				return ResponseEntity.ok(new ApiResponse(false, null, "Customer Not Found !"));
				
		}else
			return ResponseEntity.ok(new ApiResponse(false, null, "User Not Found !"));
		
	}
}
