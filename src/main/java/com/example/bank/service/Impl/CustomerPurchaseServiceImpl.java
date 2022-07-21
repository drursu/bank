package com.example.bank.service.Impl;

import com.example.bank.entity.CustomerPurchase;
import com.example.bank.exception.ResourceNotDeletedException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.exception.ResourceNotSavedException;
import com.example.bank.repository.CustomerPurchaseRepository;
import com.example.bank.service.Interface.CustomerPurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {

    private final CustomerPurchaseRepository customerPurchaseRepository;

    public List<CustomerPurchase> getAllCustomerPurchases() {
        return customerPurchaseRepository.findAll();
    }

    public CustomerPurchase getCustomerPurchaseById(Long id) {

        return customerPurchaseRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Customer Purchase with id: " + id + " does not exist!"));
    }

    public CustomerPurchase saveOrUpdateCustomerPurchase(CustomerPurchase customerPurchase) {

        try {
            customerPurchaseRepository.save(customerPurchase);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Customer Purchase could not be saved!");
        }

        return customerPurchase;
    }

    public void deleteCustomerPurchase(Long id) {

        try {
            customerPurchaseRepository.deleteById(id);
        } catch (ResourceNotDeletedException exception) {
            throw new ResourceNotDeletedException("Customer Purchase could not be deleted!");
        }
    }

    public CustomerPurchase updateCustomerPurchase(CustomerPurchase customerPurchase) {

        try {
            customerPurchaseRepository.save(customerPurchase);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Customer Purchase could not be updated!");
        }

        return customerPurchase;
    }
}
