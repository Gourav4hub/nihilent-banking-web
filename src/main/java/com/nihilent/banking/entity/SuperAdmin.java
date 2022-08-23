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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "superadmin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdmin 
{
    @Id
    @Column(name = "superadmin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer superAdminId;

    @Column(name = "superadmin_name",nullable = false)
    private String username;

    @Column(name = "superadmin_phone",unique = true, nullable = false)   
    private String superAdminPhone;

    @OneToOne
    @JoinColumn(name = "user_id")
    private BankUser user;
}
