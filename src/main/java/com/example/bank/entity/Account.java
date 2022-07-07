package com.example.bank.entity;

import com.example.bank.enums.TransactionType;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @NotNull
    private String accountName;
    @NotNull
    private Date creationDate;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @OneToOne(mappedBy = "account")
    private Transaction transactions;

}
