package com.nihilent.banking.entity;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransaction 
{
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer transactionId;

    @Column(name = "amount",nullable = false)
    private Float amount;
    
    @Column(name = "date" , nullable = false)
    private Date transactionDate;
    
    @OneToOne
    @JoinColumn(name = "sender_id")
    private Customer sender;
    
    @OneToOne
    @JoinColumn(name = "receiver_id")
    private Customer receiver;
    
    @Column(name = "description",nullable = false)
    private String description;
}
