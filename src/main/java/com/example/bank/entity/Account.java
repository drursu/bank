package com.example.bank.entity;

import com.example.bank.enums.TransactionType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String accountName;
    @CreationTimestamp
    private Date creationDate;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;
}
