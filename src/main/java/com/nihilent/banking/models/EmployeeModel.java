package com.nihilent.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel 
{
	private String name;
	private String email;
	private Float salary;
}
