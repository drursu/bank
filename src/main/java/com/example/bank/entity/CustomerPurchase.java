package com.example.bank.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class CustomerPurchase {

    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date dateOfPurchase;
    private Double purchaseCost;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "customerPurchase")
    private List<ProductsAndServices> productsAndServices;
}
