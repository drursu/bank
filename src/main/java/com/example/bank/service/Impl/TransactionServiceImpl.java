package com.example.bank.service.Impl;

import com.example.bank.entity.Transaction;
import com.example.bank.exception.ResourceNotDeletedException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.exception.ResourceNotSavedException;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.service.Interface.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {

        return transactionRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Transaction with id: " + id + " does not exist!"));
    }

    public Transaction saveOrUpdateTransaction(Transaction transaction) {

        try {
            transactionRepository.save(transaction);

        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Transaction could not be saved!");
        }

        return transaction;
    }

    public void deleteTransaction(Long id) {

        try {
            transactionRepository.deleteById(id);

        } catch (ResourceNotDeletedException exception) {
            throw new ResourceNotDeletedException("Transaction could not be deleted!");
        }
    }

    public Transaction updateTransaction(Transaction transaction) {

        try {
            transactionRepository.save(transaction);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Transaction could not be updated!");
        }

        return transaction;
    }
}
