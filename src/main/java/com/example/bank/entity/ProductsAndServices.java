package com.example.bank.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class ProductsAndServices {

    @Id
    @GeneratedValue
    private Long id;
    private String productAndServicesCode;
    private String productAndServicesDescription;
    @ManyToOne
    @JoinColumn(name = "customer_purchase_id")
    private CustomerPurchase customerPurchase;
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;
}
