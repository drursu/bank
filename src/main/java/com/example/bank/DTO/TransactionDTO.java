package com.example.bank.DTO;

import com.example.bank.entity.Account;
import com.example.bank.entity.CustomerPurchase;
import com.example.bank.enums.TransactionType;
import lombok.Data;
import java.util.Date;

@Data
public class TransactionDTO {

    private Long transactionId;
    private Date creationDate;
    private Float transactionAmount;
    private String otherDetails;
    private Account account;
    private TransactionType transactionType;
    private CustomerPurchase customerPurchase;
}
