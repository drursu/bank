package com.example.bank.DTO;

import com.example.bank.entity.CustomerPurchase;
import com.example.bank.entity.Merchant;
import lombok.Data;
import java.util.List;

@Data
public class ProductsAndServicesDTO {

    private String productAndServicesCode;
    private String productAndServicesDescription;
    private CustomerPurchase customerPurchase;
    private List<Merchant> merchants;
}
