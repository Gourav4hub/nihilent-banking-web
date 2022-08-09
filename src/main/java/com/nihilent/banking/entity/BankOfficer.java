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
@Table(name = "bank_officer")
@Data
@NoArgsConstructor
public class BankOfficer extends BaseEntity
{
	@Id
	@Column(name = "bank_officer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankOfficerId;
	
	@Column(name = "officer_name",nullable = false)
	private String officerName;
	
	@Column(name = "officer_contact",unique = true, nullable = false)
	private String officerContact;

	@OneToOne
	@JoinColumn(name = "bank")
	private BankMaster bank;
	
	@OneToOne
	@JoinColumn(name = "bankuser")
	private User user;
}
