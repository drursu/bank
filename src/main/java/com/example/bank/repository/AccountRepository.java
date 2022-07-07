package com.example.bank.repository;

import com.example.bank.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    @Override
    List<Account> findAll();

}
