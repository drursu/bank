package com.example.bank.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class CustomerPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerPurchaseId;
    @NotNull
    private Date dateOfPurchase;
    @NotNull
    private Double purchaseCost;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;
    @OneToOne(mappedBy = "customerPurchase")
    private Transaction transaction;
    @OneToOne(mappedBy = "customerPurchase")
    private ProductsAndServices productsAndServices;

}
