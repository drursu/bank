package com.example.bank.service.Interface;

import com.example.bank.entity.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long id);

    Transaction saveOrUpdateTransaction(Transaction transaction);

    void deleteTransaction(Long id);

    Transaction updateTransaction(Transaction transaction);

}
