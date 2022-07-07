package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.Customer;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.CustomerRepository;
import com.example.bank.service.Interface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer saveOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }
}
