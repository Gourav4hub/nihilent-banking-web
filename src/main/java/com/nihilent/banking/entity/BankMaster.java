package com.nihilent.banking.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_master")
@Data
@NoArgsConstructor
public class BankMaster extends BaseEntity
{
	@Id
	@Column(name = "bank_master_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankMasterId;
	
	@Column(name = "bank_name",unique = true, nullable = false)
	private String bankName;
	
	@Column(name = "bank_address",nullable = false)
	private String bankAddress;
	
	@Column(name = "bank_contact",unique = true, nullable = false)
	private String bankContact;
	
	@Column(name = "bank_ifsc",unique = true, nullable = false)
	private String bankIfsc;
	
	@Column(name = "bank_country",nullable = false)
	private String bankCountry;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "bank_account_type",
            joinColumns = {
                    @JoinColumn(name = "bank_master_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "account_type_master_id") })
    private Set<AccountTypeMaster> accountTypes;
}
