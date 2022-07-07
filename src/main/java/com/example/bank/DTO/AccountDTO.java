package com.example.bank.DTO;

import com.example.bank.entity.Customer;
import com.example.bank.enums.TransactionType;
import lombok.Data;
import java.util.Date;

@Data
public class AccountDTO {

    private Long accountId;
    private String accountName;
    private Date creationDate;
    private String otherDetails;
    private Customer customer;
    private TransactionType transactionType;
}
