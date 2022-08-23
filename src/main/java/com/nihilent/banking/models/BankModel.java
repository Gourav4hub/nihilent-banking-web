package com.nihilent.banking.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankModel 
{
    private String bankName;
    private String bankAddress;
    private String bankContact;
    private String bankIfsc;
    private String bankCountry;
    private Integer types[];
}
