package com.nihilent.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User extends BaseEntity
{
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name = "user_name",unique = true, nullable = false)
	private String userName;
	
	@Column(name = "user_type",nullable = false)
	private String userType;
	
	@Column(name = "user_password",nullable = false)
	private String userPassword;
	
	@OneToOne
	@JoinColumn(name = "user_role")
	private Role userRole;
}
