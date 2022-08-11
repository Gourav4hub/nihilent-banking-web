package com.nihilent.banking.models;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalaryRecordModel 
{	
	private String month;	
	private Float amount;	
	private Float bonus;
}
