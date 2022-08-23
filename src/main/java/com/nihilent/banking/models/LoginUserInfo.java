package com.nihilent.banking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo 
{
	private String username;
	private String usertype;
	private String token;
}
