package com.example.bank.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Merchant {

    @Id
    @GeneratedValue
    private Long id;
    private String merchantName;
    private String merchantPhoneNumber;
    private String merchantEmailAddress;
    private String otherDetails;
    @OneToMany(mappedBy = "merchant")
    private List<ProductsAndServices> productsAndServices;
}
