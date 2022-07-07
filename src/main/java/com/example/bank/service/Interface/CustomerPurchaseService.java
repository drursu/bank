package com.example.bank.service.Interface;

import com.example.bank.entity.CustomerPurchase;

import java.util.List;
import java.util.Optional;

public interface CustomerPurchaseService {
    public List<CustomerPurchase> getAllCustomerPurchases();

    public Optional<CustomerPurchase> getCustomerPurchaseById(Long id);

    public CustomerPurchase saveOrUpdateCustomerPurchase(CustomerPurchase customerPurchase);

    public void deleteCustomerPurchase(Long id);

    public CustomerPurchase updateCustomerPurchase(CustomerPurchase customerPurchase);

}
