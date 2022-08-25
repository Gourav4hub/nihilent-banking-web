package com.nihilent.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel 
{
	  private Integer accountType;
	  private Float balance;
	  private Float preDayLimit;
	  private Float perTransactionLimit;
	  private Integer customer;  
}
