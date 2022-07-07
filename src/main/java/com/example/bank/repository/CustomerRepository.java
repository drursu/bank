package com.example.bank.repository;

import com.example.bank.entity.Account;
import com.example.bank.entity.Customer;
import com.example.bank.entity.CustomerPurchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Override
    List<Customer> findAll();
}
