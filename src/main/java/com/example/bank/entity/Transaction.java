package com.example.bank.entity;

import com.example.bank.enums.TransactionType;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Transaction {

    @Id
    private Long transactionId;
    @NotNull
    private Date creationDate;
    @NotNull
    private Float transactionAmount;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @OneToOne
    @JoinColumn(name = "customerPurchaseId")
    private CustomerPurchase customerPurchase;

}
