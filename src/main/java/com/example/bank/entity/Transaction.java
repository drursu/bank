package com.example.bank.entity;

import com.example.bank.enums.TransactionType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date creationDate;
    private Float transactionAmount;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @OneToOne
    @JoinColumn(name = "customerPurchaseId")
    private CustomerPurchase customerPurchase;
}
