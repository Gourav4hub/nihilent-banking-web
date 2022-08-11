package com.nihilent.banking.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nihilent.banking.models.EmployeeModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_info")
@Data
@NoArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "empId")
public class Employee extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "emp_name",nullable = false)
	private String empName;
	
	@Column(name = "emp_email",nullable = false,unique = true)
	private String empEmail;
	
	@Column(name = "emp_salary",nullable = false)
	private Float empSalary;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private List<SalaryRecord> salaryRecords;
	
	public Employee(EmployeeModel model) 
	{
		this.empName = model.getName();
		this.empEmail = model.getEmail();
		this.empSalary = model.getSalary();
	}
}
