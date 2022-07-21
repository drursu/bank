package com.example.bank.service.Interface;

import com.example.bank.entity.Account;
import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    Account getAccountById(Long id);

    Account saveOrUpdateAccount(Account account);

    void deleteAccount(Long id);

    Account updateAccount(Account account);

}
