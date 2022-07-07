package com.example.bank.DTO;

import com.example.bank.entity.Account;
import com.example.bank.entity.CustomerPurchase;
import com.example.bank.enums.CustomerType;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class CustomerDTO {

    private Long customerId;
    private String customerName;
    private String customerPhoneNumber;
    private String customerEmailAddress;
    private Date customerRegistrationDate;
    private String username;
    private String password;
    private String otherDetails;
    private CustomerType customerType;
    private List<Account> accounts;
    private List<CustomerPurchase> customerPurchases;
}
