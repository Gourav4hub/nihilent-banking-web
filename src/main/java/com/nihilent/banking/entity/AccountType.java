package com.nihilent.banking.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountType 
{
    @Id
    @Column(name = "account_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountTypeId;

    @Column(name = "account_type_name",unique = true,nullable = false)
    private String accountTypeName;
}
