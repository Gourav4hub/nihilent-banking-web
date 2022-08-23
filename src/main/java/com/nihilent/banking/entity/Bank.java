package com.nihilent.banking.entity;

import java.util.Set;

import javax.persistence.*;

import com.nihilent.banking.models.BankModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank 
{
  
	@Id
    @Column(name = "bank_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bankId;

    @Column(name = "bank_name",unique = true,nullable = false)
    private String bankName;
    
    @Column(name = "bank_address",nullable = false)
    private String bankAddress;

    
    @Column(name = "bank_contact",unique = true,nullable = false)
    private String bankContact;

    
    @Column(name = "bank_ifsc",unique = true,nullable = false)
    private String bankIfsc;

    
    @Column(name = "bank_country",nullable = false)
    private String bankCountry;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "BANK_ACCOUNT_TYPE",
            joinColumns = {
                    @JoinColumn(name = "bank_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "account_type_id") })
    private Set<AccountType> accountTypes;
    
    
    public Bank(BankModel model) {
    	this.bankName = model.getBankName();
    	this.bankAddress = model.getBankAddress();
    	this.bankContact = model.getBankContact();
    	this.bankIfsc = model.getBankIfsc();
    	this.bankCountry = model.getBankCountry();
  	}



}
