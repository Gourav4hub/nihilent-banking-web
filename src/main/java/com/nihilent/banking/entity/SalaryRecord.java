package com.nihilent.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nihilent.banking.models.EmployeeModel;
import com.nihilent.banking.models.SalaryRecordModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_salary_record")
@Data
@NoArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "salaryRecordId")
public class SalaryRecord extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "salary_record_id")
	private Integer salaryRecordId;
	
	@Column(name = "month",nullable = false)
	private String month;
	
	@Column(name = "amount",nullable = false)
	private Float amount;
	
	@Column(name = "bonus",nullable = false)
	private Float bonus;	
	
	@ManyToOne
	@JoinColumn(name = "employee")
	private Employee employee;
	
	public SalaryRecord(SalaryRecordModel model) {
		this.month = model.getMonth();
		this.amount = model.getAmount();
		this.bonus = model.getBonus();
	}
	
}
