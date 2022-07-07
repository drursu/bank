package com.example.bank.service.Interface;

import com.example.bank.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public Optional<Customer> getCustomerById(Long id);

    public Customer saveOrUpdateCustomer(Customer customer);

    public void deleteCustomer(Long id);

    public Customer updateCustomer(Customer customer);

}
