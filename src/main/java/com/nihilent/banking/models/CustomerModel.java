package com.nihilent.banking.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel 
{
	private String officerId;
	private String userName;
    private String customerName;
    private String customerPhone;
    private String email;
    private String password;
}
