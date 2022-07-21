package com.example.bank.service.Interface;

import com.example.bank.entity.CustomerPurchase;
import java.util.List;

public interface CustomerPurchaseService {
    List<CustomerPurchase> getAllCustomerPurchases();

    CustomerPurchase getCustomerPurchaseById(Long id);

    CustomerPurchase saveOrUpdateCustomerPurchase(CustomerPurchase customerPurchase);

    void deleteCustomerPurchase(Long id);

    CustomerPurchase updateCustomerPurchase(CustomerPurchase customerPurchase);

}
