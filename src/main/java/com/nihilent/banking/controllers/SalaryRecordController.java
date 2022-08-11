package com.nihilent.banking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihilent.banking.entity.Employee;
import com.nihilent.banking.entity.SalaryRecord;
import com.nihilent.banking.models.EmployeeModel;
import com.nihilent.banking.models.SalaryRecordModel;
import com.nihilent.banking.response.ApiResponse;
import com.nihilent.banking.services.EmployeeService;
import com.nihilent.banking.services.SalaryRecordService;

@RestController
@RequestMapping("/salaryrecord")
public class SalaryRecordController 
{
	@Autowired
	private EmployeeService empService;
	@Autowired
	private SalaryRecordService salaryRecordService;
	
	@PostMapping("/save/{id}")
	public ResponseEntity<ApiResponse> save(@PathVariable(name = "id") Integer id,
			@RequestBody SalaryRecordModel model)
	{
		Employee emp = empService.get(id);
		if(emp==null)
			return ResponseEntity.ok(new ApiResponse(false, null, "Employee Not Found !"));
		else {
			SalaryRecord rec = new SalaryRecord(model);
			rec.setEmployee(emp);
			
			boolean status = salaryRecordService.save(rec);
			if(status)
				return ResponseEntity.ok(new ApiResponse(status, null, "Salary Record Saved Successfully !"));
			else
				return ResponseEntity.ok(new ApiResponse(status, null, "Salary Record Not Saved !"));
		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> update(@PathVariable(name = "id") Integer id,
				@RequestBody SalaryRecordModel model)
	{		
		SalaryRecord rec = salaryRecordService.get(id);
		if(rec==null)
			return ResponseEntity.ok(new ApiResponse(false, null, "Record Not Found !"));
		else {
			rec.setAmount(model.getAmount());
			rec.setBonus(model.getBonus());
			rec.setMonth(model.getMonth());
			
			boolean status = salaryRecordService.save(rec);
			if(status)
				return ResponseEntity.ok(new ApiResponse(status, null, "Salary Record Updated Successfully !"));
			else
				return ResponseEntity.ok(new ApiResponse(status, null, "Salary Record Not Updated !"));
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<ApiResponse> list()
	{
		return ResponseEntity.ok(new ApiResponse(true,salaryRecordService.list(),null));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ApiResponse> get(@PathVariable(name = "id") Integer id)
	{
		SalaryRecord rec = salaryRecordService.get(id);
		if(rec==null)
			return ResponseEntity.ok(new ApiResponse(false, null, "Record Not Found !"));
		else 
			return ResponseEntity.ok(new ApiResponse(true, rec, "Record Found !"));
	}
}
