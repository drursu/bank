package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.Transaction;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.service.Interface.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveOrUpdateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
        return transaction;
    }
}
