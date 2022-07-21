package com.example.bank.controller;

import com.example.bank.DTO.CustomerDTO;
import com.example.bank.entity.Customer;
import com.example.bank.service.Impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")

public class CustomerController {

    private final ModelMapper modelMapper;

    private final CustomerServiceImpl customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {

        return customerService.getAllCustomers().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long id) {

        Customer customer = customerService.getCustomerById(id);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        return customerDTO;
    }

    @PostMapping
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customerPostRequest = modelMapper.map(customerDTO, Customer.class);
        Customer customerPostResponse = customerService.saveOrUpdateCustomer(customerPostRequest);
        CustomerDTO customerDTOResponse = modelMapper.map(customerPostResponse, CustomerDTO.class);

        return customerDTOResponse;
    }

    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customerPostRequest = modelMapper.map(customerDTO, Customer.class);
        Customer customerPostResponse = customerService.updateCustomer(customerPostRequest);
        CustomerDTO customerDTOResponse = modelMapper.map(customerPostResponse, CustomerDTO.class);

        return customerDTOResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted !";
    }
}
