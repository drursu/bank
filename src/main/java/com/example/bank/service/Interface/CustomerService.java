package com.example.bank.service.Interface;

import com.example.bank.entity.Customer;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Long id);

    Customer updateCustomer(Customer customer);

}
