package com.nihilent.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.banking.entity.Employee;
import com.nihilent.banking.models.EmployeeModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController 
{
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/save")
	public ResponseEntity<ApiResponse> save(@RequestBody EmployeeModel empModel)
	{
		System.out.println("EMP : " + empModel);
		Employee emp = new Employee(empModel);
		boolean status = empService.save(emp);
		if(status)
			return ResponseEntity.ok(new ApiResponse(status, null, "Employee Saved Successfully !"));
		else
			return ResponseEntity.ok(new ApiResponse(status, null, "Employee Not Saved !"));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> update(@PathVariable(name = "id") Integer id,
				@RequestBody EmployeeModel empModel)
	{		
		Employee emp = empService.get(id);
		if(emp==null)
			return ResponseEntity.ok(new ApiResponse(false, null, "Employee Not Found !"));
		else {
			emp.setEmpName(empModel.getName());
			emp.setEmpEmail(empModel.getEmail());
			emp.setEmpSalary(empModel.getSalary());
			boolean status = empService.update(emp);
			if(status)
				return ResponseEntity.ok(new ApiResponse(status, null, "Employee Updated Successfully !"));
			else
				return ResponseEntity.ok(new ApiResponse(status, null, "Employee Not Updated !"));
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> list()
	{
		return ResponseEntity.ok(new ApiResponse(true,empService.list(),null));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ApiResponse> get(@PathVariable(name = "id") Integer id)
	{
		Employee emp = empService.get(id);
		if(emp==null)
			return ResponseEntity.ok(new ApiResponse(false, null, "Employee Not Found !"));
		else 
			return ResponseEntity.ok(new ApiResponse(true, emp, "Employee Found !"));
	}
}
