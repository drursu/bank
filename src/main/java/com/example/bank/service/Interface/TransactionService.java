package com.example.bank.service.Interface;

import com.example.bank.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    public List<Transaction> getAllTransaction();

    public Optional<Transaction> getTransactionById(Long id);

    public Transaction saveOrUpdateTransaction(Transaction transaction);

    public void deleteTransaction(Long id);

    public Transaction updateTransaction(Transaction transaction);

}
