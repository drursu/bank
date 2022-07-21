package com.example.bank.controller;

import com.example.bank.DTO.TransactionDTO;
import com.example.bank.entity.Transaction;
import com.example.bank.service.Impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final ModelMapper modelMapper;

    private final TransactionServiceImpl transactionService;

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {

        return transactionService.getAllTransactions().stream().map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public TransactionDTO getTransactionById(@PathVariable("id") Long id) {

        Transaction transaction = transactionService.getTransactionById(id);
        TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);

        return transactionDTO;
    }

    @PostMapping
    public TransactionDTO saveOrUpdateTransaction(@RequestBody TransactionDTO transactionDTO) {

        Transaction transactionPostRequest = modelMapper.map(transactionDTO, Transaction.class);
        Transaction transactionPostResponse = transactionService.saveOrUpdateTransaction(transactionPostRequest);
        TransactionDTO transactionDTOResponse = modelMapper.map(transactionPostResponse, TransactionDTO.class);

        return transactionDTOResponse;
    }

    @PutMapping
    public TransactionDTO updateTransaction(@RequestBody TransactionDTO transactionDTO) {

        Transaction transactionPostRequest = modelMapper.map(transactionDTO, Transaction.class);
        Transaction transactionPostResponse = transactionService.updateTransaction(transactionPostRequest);
        TransactionDTO transactionDTOResponse = modelMapper.map(transactionPostResponse, TransactionDTO.class);

        return transactionDTOResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable(name = "id") Long id) {

        transactionService.deleteTransaction(id);

        return "Transaction deleted !";
    }
}
