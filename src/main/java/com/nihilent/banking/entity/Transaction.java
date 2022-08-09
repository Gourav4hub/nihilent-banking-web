package com.nihilent.banking.entity;

import java.time.LocalDate;
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
@Table(name = "account_transaction")
@Data
@NoArgsConstructor
public class Transaction extends BaseEntity
{
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	@Column(name = "transaction_amount",nullable = false)
	private Float transactionAmount;
	
	@Column(name = "transaction_date",nullable = false)
	private LocalDate transactionDate;
	
	@Column(name = "description",nullable = false)
	private String description;

	@OneToOne
	@JoinColumn(name = "sender")
	private Customer sender;
	
	@OneToOne
	@JoinColumn(name = "receiver")
	private Customer receiver;
}
