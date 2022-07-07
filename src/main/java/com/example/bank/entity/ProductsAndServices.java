package com.example.bank.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProductsAndServices {

    @Id
    private String productAndServicesCode;
    private String productAndServicesDescription;
    @OneToOne
    @JoinColumn(name = "customerPurchaseId")
    private CustomerPurchase customerPurchase;
    @OneToMany(mappedBy = "productsAndServices")
    private List<Merchant> merchants;

}
