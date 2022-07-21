package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.exception.ResourceNotDeletedException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.exception.ResourceNotSavedException;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.Interface.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {

        return accountRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Account with id: " + id + " does not exist!"));
    }

    public Account saveOrUpdateAccount(Account account) {

        try {
            accountRepository.save(account);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Account could not be saved!");
        }

        return account;
    }

    public void deleteAccount(Long id) {

        try {
            accountRepository.deleteById(id);
        } catch (ResourceNotDeletedException exception) {
            throw new ResourceNotDeletedException("Account could not be deleted!");
        }
    }

    public Account updateAccount(Account account) {

        try {
            accountRepository.save(account);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Account could not be updated!");
        }

        return account;
    }
}
