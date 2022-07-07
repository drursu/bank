package com.example.bank.controller;

import com.example.bank.DTO.AccountDTO;
import com.example.bank.DTO.CustomerDTO;
import com.example.bank.DTO.CustomerPurchaseDTO;
import com.example.bank.entity.Account;
import com.example.bank.entity.Customer;
import com.example.bank.entity.CustomerPurchase;
import com.example.bank.service.Impl.AccountServiceImpl;
import com.example.bank.service.Impl.CustomerPurchaseServiceImpl;
import com.example.bank.service.Impl.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer-purchase")

public class CustomerPurchaseController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CustomerPurchaseServiceImpl customerPurchaseService;

    @GetMapping
    public List<CustomerPurchaseDTO> getAllCustomerPurchases() {

        return customerPurchaseService.getAllCustomerPurchases().stream().map(customerPurchase -> modelMapper.map(customerPurchase, CustomerPurchaseDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Optional<CustomerPurchaseDTO> getCustomerPurchaseById(@PathVariable("id") Long id) {

        Optional<CustomerPurchase> customerPurchase = customerPurchaseService.getCustomerPurchaseById(id);
        CustomerPurchaseDTO customerPurchaseDTO = modelMapper.map(customerPurchase, CustomerPurchaseDTO.class);

        return Optional.ofNullable(customerPurchaseDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerPurchaseDTO> saveCustomerPurchase(@RequestBody CustomerPurchaseDTO customerPurchaseDTO) {

        CustomerPurchase customerPurchasePostRequest = modelMapper.map(customerPurchaseDTO,CustomerPurchase.class);
        CustomerPurchase customerPurchasePostResponse = customerPurchaseService.saveOrUpdateCustomerPurchase(customerPurchasePostRequest);
        CustomerPurchaseDTO customerPurchaseDTOResponse = modelMapper.map(customerPurchasePostResponse,CustomerPurchaseDTO.class);

        return new ResponseEntity<>(customerPurchaseDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerPurchaseDTO> updateCustomer(@RequestBody CustomerPurchaseDTO customerPurchaseDTO) {

        CustomerPurchase customerPurchasePostRequest = modelMapper.map(customerPurchaseDTO,CustomerPurchase.class);
        CustomerPurchase customerPurchasePostResponse = customerPurchaseService.updateCustomerPurchase(customerPurchasePostRequest);
        CustomerPurchaseDTO customerPurchaseDTOResponse = modelMapper.map(customerPurchasePostResponse,CustomerPurchaseDTO.class);

        return ResponseEntity.ok().body(customerPurchaseDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerPurchase(@PathVariable(name = "id") Long id){
        customerPurchaseService.deleteCustomerPurchase(id);
        return new ResponseEntity<>("Customer Purchase deleted !", HttpStatus.OK);
    }
}
