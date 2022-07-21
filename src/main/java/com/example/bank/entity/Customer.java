package com.example.bank.entity;

import com.example.bank.enums.CustomerType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String customerPhoneNumber;
    @Column(nullable = false)
    private String customerEmailAddress;
    @CreationTimestamp
    private Date customerRegistrationDate;
    @Column(unique=true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String otherDetails;
    @Enumerated(EnumType.STRING)
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;
    @OneToMany(mappedBy = "customer")
    private List<CustomerPurchase> customerPurchases;
}
