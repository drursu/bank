package com.example.bank.controller;

import com.example.bank.entity.Transaction;
import com.example.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller

public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping("/profile")
    @ResponseBody

    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("ceva");
    }

    @GetMapping("/transactions")
    @ResponseBody
    public Iterable<Transaction> getAllTransactions() {

        return transactionRepository.findAll();

    }


}
