package com.example.bank.controller;

import com.example.bank.DTO.CustomerPurchaseDTO;
import com.example.bank.entity.CustomerPurchase;
import com.example.bank.service.Impl.CustomerPurchaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer-purchases")

public class CustomerPurchaseController {

    private final ModelMapper modelMapper;

    private final CustomerPurchaseServiceImpl customerPurchaseService;

    @GetMapping
    public List<CustomerPurchaseDTO> getAllCustomerPurchases() {

        return customerPurchaseService.getAllCustomerPurchases().stream().map(customerPurchase -> modelMapper.map(customerPurchase, CustomerPurchaseDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerPurchaseDTO getCustomerPurchaseById(@PathVariable("id") Long id) {

        CustomerPurchase customerPurchase = customerPurchaseService.getCustomerPurchaseById(id);
        CustomerPurchaseDTO customerPurchaseDTO = modelMapper.map(customerPurchase, CustomerPurchaseDTO.class);

        return customerPurchaseDTO;
    }

    @PostMapping
    public CustomerPurchaseDTO saveCustomerPurchase(@RequestBody CustomerPurchaseDTO customerPurchaseDTO) {

        CustomerPurchase customerPurchasePostRequest = modelMapper.map(customerPurchaseDTO, CustomerPurchase.class);
        CustomerPurchase customerPurchasePostResponse = customerPurchaseService.saveOrUpdateCustomerPurchase(customerPurchasePostRequest);
        CustomerPurchaseDTO customerPurchaseDTOResponse = modelMapper.map(customerPurchasePostResponse, CustomerPurchaseDTO.class);

        return customerPurchaseDTOResponse;
    }

    @PutMapping
    public CustomerPurchaseDTO updateCustomer(@RequestBody CustomerPurchaseDTO customerPurchaseDTO) {

        CustomerPurchase customerPurchasePostRequest = modelMapper.map(customerPurchaseDTO, CustomerPurchase.class);
        CustomerPurchase customerPurchasePostResponse = customerPurchaseService.updateCustomerPurchase(customerPurchasePostRequest);
        CustomerPurchaseDTO customerPurchaseDTOResponse = modelMapper.map(customerPurchasePostResponse, CustomerPurchaseDTO.class);

        return customerPurchaseDTOResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerPurchase(@PathVariable(name = "id") Long id) {

        customerPurchaseService.deleteCustomerPurchase(id);

        return "Customer Purchase deleted !";
    }
}
