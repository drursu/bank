package com.example.bank.controller;

import com.example.bank.DTO.CustomerDTO;
import com.example.bank.entity.Customer;
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
@RequestMapping("/customer")

public class CustomerController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {

        return customerService.getAllCustomers().stream().map(customer -> modelMapper.map(customer, CustomerDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Optional<CustomerDTO> getCustomerById(@PathVariable("id") Long id) {

        Optional<Customer> customer = customerService.getCustomerById(id);
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);

        return Optional.ofNullable(customerDTO);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customerPostRequest = modelMapper.map(customerDTO,Customer.class);
        Customer customerPostResponse = customerService.saveOrUpdateCustomer(customerPostRequest);
        CustomerDTO customerDTOResponse = modelMapper.map(customerPostResponse,CustomerDTO.class);

        return new ResponseEntity<>(customerDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {

        Customer customerPostRequest = modelMapper.map(customerDTO,Customer.class);
        Customer customerPostResponse = customerService.updateCustomer(customerPostRequest);
        CustomerDTO customerDTOResponse = modelMapper.map(customerPostResponse,CustomerDTO.class);

        return ResponseEntity.ok().body(customerDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name = "id") Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted !", HttpStatus.OK);
    }
}
