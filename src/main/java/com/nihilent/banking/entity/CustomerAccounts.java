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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_accounts")
@Data
@NoArgsConstructor
public class CustomerAccounts extends BaseEntity
{
	@Id
	@Column(name = "customer_account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerAccountId;
	
	@Column(name = "account_name",unique = true,nullable = false)
	private String accountName;
	
	@Column(name = "balance" ,nullable = false)
	private Float balance;
	
	@Column(name = "per_day_limit" ,nullable = false)
	private Float perDayLimit;
	
	@Column(name = "per_trans_limi" ,nullable = false)
	private Float perTransLimit;
	

	@OneToOne
	@JoinColumn(name = "customer")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "account_type")
	private AccountTypeMaster accountType;
}
