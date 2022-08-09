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
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer extends BaseEntity
{
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Column(name = "customer_name",nullable = false)
	private String customerName;
	
	@Column(name = "customer_upi",unique = true, nullable = false)
	private String customerUpi;
	
	@Column(name = "customer_contact",unique = true, nullable = false)
	private String customerContact;

	@OneToOne
	@JoinColumn(name = "bank")
	private BankMaster bank;
	
	@OneToOne
	@JoinColumn(name = "bankuser")
	private User user;
}
