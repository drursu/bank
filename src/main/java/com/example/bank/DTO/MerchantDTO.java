package com.example.bank.DTO;

import com.example.bank.entity.ProductsAndServices;
import lombok.Data;

@Data
public class MerchantDTO {

    private Long id;
    private String merchantName;
    private String merchantPhoneNumber;
    private String merchantEmailAddress;
    private String otherDetails;
    private ProductsAndServices productsAndServices;
}
