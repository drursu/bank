package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.CustomerPurchase;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.CustomerPurchaseRepository;
import com.example.bank.service.Interface.CustomerPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {
    @Autowired
    CustomerPurchaseRepository customerPurchaseRepository;

    public List<CustomerPurchase> getAllCustomerPurchases() {
        return customerPurchaseRepository.findAll();
    }

    public Optional<CustomerPurchase> getCustomerPurchaseById(Long id) {
        return customerPurchaseRepository.findById(id);
    }

    public CustomerPurchase saveOrUpdateCustomerPurchase(CustomerPurchase customerPurchase) {
        customerPurchaseRepository.save(customerPurchase);
        return customerPurchase;
    }

    public void deleteCustomerPurchase(Long id) {
        customerPurchaseRepository.deleteById(id);
    }

    public CustomerPurchase updateCustomerPurchase(CustomerPurchase customerPurchase) {
        customerPurchaseRepository.save(customerPurchase);
        return customerPurchase;
    }
}
