package com.example.bank.controller;

import com.example.bank.DTO.AccountDTO;
import com.example.bank.entity.Account;
import com.example.bank.service.Impl.AccountServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    AccountServiceImpl accountService;

    @GetMapping
    public List<AccountDTO> getAllAccounts() {

        return accountService.getAllAccounts().stream().map(account -> modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Optional<AccountDTO> getAccountById(@PathVariable("id") Long id) {

        Optional<Account> account = accountService.getAccountById(id);
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        return Optional.ofNullable(accountDTO);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO) {

        Account accountPostRequest = modelMapper.map(accountDTO,Account.class);
        Account accountPostResponse = accountService.saveOrUpdateAccount(accountPostRequest);
        AccountDTO accountDTOResponse = modelMapper.map(accountPostResponse,AccountDTO.class);

        return new ResponseEntity<>(accountDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO) {

        Account accountPostRequest = modelMapper.map(accountDTO,Account.class);
        Account accountPostResponse = accountService.updateAccount(accountPostRequest);
        AccountDTO accountDTOResponse = modelMapper.map(accountPostResponse,AccountDTO.class);

        return ResponseEntity.ok().body(accountDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable(name = "id") Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Account deleted !", HttpStatus.OK);
    }

}
