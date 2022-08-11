package com.nihilent.banking.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse 
{
	private boolean status;
	private Object data;
	private String msg;
}
