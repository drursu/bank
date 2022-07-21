package com.example.bank.service.Impl;

import com.example.bank.entity.Customer;
import com.example.bank.exception.ResourceNotDeletedException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.exception.ResourceNotSavedException;
import com.example.bank.repository.CustomerRepository;
import com.example.bank.service.Interface.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Customer with id: " + id + " could not be found!")
        );
    }

    public Customer saveOrUpdateCustomer(Customer customer) {

        try {
            customerRepository.save(customer);

        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Customer could not be saved!");

        }

        return customer;
    }

    public void deleteCustomer(Long id) {

        try {
            customerRepository.deleteById(id);
        } catch (ResourceNotDeletedException exception) {
            throw new ResourceNotDeletedException("Customer could not be deleted!");
        }
    }

    public Customer updateCustomer(Customer customer) {

        try {
            customerRepository.save(customer);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Customer could not be updated!");
        }

        return customer;
    }
}
