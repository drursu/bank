package com.example.bank.controller;

import com.example.bank.DTO.AccountDTO;
import com.example.bank.entity.Account;
import com.example.bank.service.Impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final ModelMapper modelMapper;
    private final AccountServiceImpl accountService;

    @GetMapping
    public List<AccountDTO> getAllAccounts() {

        return accountService.getAllAccounts().stream().map(account -> modelMapper.map(account, AccountDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public AccountDTO getAccountById(@PathVariable("id") Long id) {


        Account account = accountService.getAccountById(id);
        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        return accountDTO;

    }

    @PostMapping
    public AccountDTO saveAccount(@RequestBody AccountDTO accountDTO) {

        Account accountPostRequest = modelMapper.map(accountDTO, Account.class);
        Account accountPostResponse = accountService.saveOrUpdateAccount(accountPostRequest);
        AccountDTO accountDTOResponse = modelMapper.map(accountPostResponse, AccountDTO.class);

        return accountDTOResponse;
    }

    @PutMapping
    public AccountDTO updateAccount(@RequestBody AccountDTO accountDTO) {

        Account accountPostRequest = modelMapper.map(accountDTO, Account.class);
        Account accountPostResponse = accountService.updateAccount(accountPostRequest);
        AccountDTO accountDTOResponse = modelMapper.map(accountPostResponse, AccountDTO.class);

        return accountDTOResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable(name = "id") Long id) {
        accountService.deleteAccount(id);
        return "Account deleted !";
    }

}
