package com.nihilent.banking.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankOfficerModel 
{
	private Integer bankId;
	private String userName;
    private String officerName;
    private String officerPhone;
    private String email;
    private String password;
}
