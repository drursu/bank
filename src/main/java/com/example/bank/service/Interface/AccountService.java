package com.example.bank.service.Interface;

import com.example.bank.entity.Account;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    public List<Account> getAllAccounts();

    public Optional<Account> getAccountById(Long id);

    public Account saveOrUpdateAccount(Account account);

    public void deleteAccount(Long id);

    public Account updateAccount(Account account);

}
