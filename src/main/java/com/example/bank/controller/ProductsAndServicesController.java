package com.example.bank.controller;

import com.example.bank.DTO.ProductsAndServicesDTO;
import com.example.bank.entity.ProductsAndServices;
import com.example.bank.service.Impl.ProductsAndServicesServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products-and-services")
public class ProductsAndServicesController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ProductsAndServicesServiceImpl productsAndServicesService;

    @GetMapping
    public List<ProductsAndServicesDTO> getAllProductsAndServices() {

        return productsAndServicesService.getAllProductsAndServices().stream().map(productsAndServices -> modelMapper.map(productsAndServices, ProductsAndServicesDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Optional<ProductsAndServicesDTO> getProductsAndServicesById(@PathVariable("id") Long id) {

        Optional<ProductsAndServices> productsAndServices = productsAndServicesService.getProductsAndServicesById(id);
        ProductsAndServicesDTO productsAndServicesDTO = modelMapper.map(productsAndServices, ProductsAndServicesDTO.class);

        return Optional.ofNullable(productsAndServicesDTO);
    }

    @PostMapping
    public ResponseEntity<ProductsAndServicesDTO> saveProductsAndServices(@RequestBody ProductsAndServicesDTO productsAndServicesDTO) {

        ProductsAndServices productsAndServicesPostRequest = modelMapper.map(productsAndServicesDTO,ProductsAndServices.class);
        ProductsAndServices productsAndServicesPostResponse = productsAndServicesService.saveOrUpdateProductsAndServices(productsAndServicesPostRequest);
        ProductsAndServicesDTO productsAndServicesDTOResponse = modelMapper.map(productsAndServicesPostResponse,ProductsAndServicesDTO.class);

        return new ResponseEntity<>(productsAndServicesDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductsAndServicesDTO> updateProductsAndServices(@RequestBody ProductsAndServicesDTO productsAndServicesDTO) {

        ProductsAndServices productsAndServicesPostRequest = modelMapper.map(productsAndServicesDTO,ProductsAndServices.class);
        ProductsAndServices productsAndServicesPostResponse = productsAndServicesService.updateProductsAndServices(productsAndServicesPostRequest);
        ProductsAndServicesDTO productsAndServicesDTOResponse = modelMapper.map(productsAndServicesPostResponse,ProductsAndServicesDTO.class);

        return ResponseEntity.ok().body(productsAndServicesDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductsAndServices(@PathVariable(name = "id") Long id){
        productsAndServicesService.deleteProductsAndServices(id);
        return new ResponseEntity<>("Product And Services deleted !", HttpStatus.OK);
    }
}
