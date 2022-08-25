package com.nihilent.banking.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccount 
{
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer accountId;

    @Column(name = "account_number",unique = true,nullable = false)
    private Long accountNumber;
    
    @OneToOne
    @JoinColumn(name = "customer_account_type")
    private AccountType accountType;
    
    @Column(name = "balance",nullable = false)
    private Float balance;
    
    @Column(name = "per_day_limit",nullable = false)
    private Float preDayLimit;
    
    @Column(name = "per_tranasaction_limit",nullable = false)
    private Float perTransactionLimit;
    
}
