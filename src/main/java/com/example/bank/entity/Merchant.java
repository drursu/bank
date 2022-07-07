package com.example.bank.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String merchantName;
    @NotNull
    private String merchantPhoneNumber;
    @NotNull
    private String merchantEmailAddress;
    private String otherDetails;
    @ManyToOne
    @JoinColumn(name="productAndServicesCode")
    private ProductsAndServices productsAndServices;

}
