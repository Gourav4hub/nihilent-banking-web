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
@Table(name = "superadmin")
@Data
@NoArgsConstructor
public class SuperAdmin extends BaseEntity
{
	@Id
	@Column(name = "superadmin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer superAdminId;
	
	@Column(name = "admin_name",nullable = false)
	private String adminName;
	
	@Column(name = "admin_contact",unique = true, nullable = false)
	private String adminContact;

	@OneToOne
	@JoinColumn(name = "user")
	private User user;
}
