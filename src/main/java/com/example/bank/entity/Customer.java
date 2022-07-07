package com.example.bank.entity;


import com.example.bank.enums.CustomerType;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @NotNull
    private String customerName;
    @NotNull
    private String customerPhoneNumber;
    @NotNull
    private String customerEmailAddress;
    @CreationTimestamp
    private Date customerRegistrationDate;
    @NotNull
    @Column(unique=true)
    private String username;
    @NotNull
    private String password;
    private String otherDetails;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
    @OneToMany(mappedBy = "customer")
    private List<CustomerPurchase> customerPurchases;

}
