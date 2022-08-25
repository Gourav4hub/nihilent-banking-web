package com.nihilent.banking.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer 
{
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "customer_name",nullable = false)
    private String customerName;
    
    @Column(name = "customer_upi",unique = true,nullable = false)
    private String customerUpi;
    
    @Column(name = "customer_phone",unique = true, nullable = false)   
    private String customerPhone;
    
    @OneToOne
    @JoinColumn(name = "customer_bank_id")
    private Bank bank;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private BankUser user;
    
    @OneToOne
    @JoinColumn(name = "customer_account_id")
    private CustomerAccount account;
}
