package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.Interface.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account saveOrUpdateAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Account updateAccount(Account account) {
         accountRepository.save(account);
        return account;
    }

}
