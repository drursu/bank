package com.example.bank.DTO;

import com.example.bank.entity.Customer;
import com.example.bank.entity.ProductsAndServices;
import com.example.bank.entity.Transaction;
import lombok.Data;
import java.util.Date;

@Data
public class CustomerPurchaseDTO {

    private Long customerPurchaseId;
    private Date dateOfPurchase;
    private Double purchaseCost;
    private String otherDetails;
    private Customer customer;
    private Transaction transaction;
    private ProductsAndServices productsAndServices;
}
