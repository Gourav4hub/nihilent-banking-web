package com.nihilent.banking.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_officer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankOfficer 
{
    @Id
    @Column(name = "officer_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer officerId;

    @Column(name = "officer_name",unique = true,nullable = false)
    private String officerName;
    
    @Column(name = "officer_phone",unique = true, nullable = false)   
    private String officerPhone;
    
    @OneToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
