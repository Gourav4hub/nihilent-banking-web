package com.nihilent.banking.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_type_master")
@Data
@NoArgsConstructor
public class AccountTypeMaster extends BaseEntity
{
	@Id
	@Column(name = "account_type_master_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountTypeMasterId;
	
	@Column(name = "account_type_name",unique = true, nullable = false)
	private String accountTypeName;
	
}
