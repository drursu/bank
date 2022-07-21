package com.example.bank.controller;

import com.example.bank.DTO.ProductsAndServicesDTO;
import com.example.bank.entity.ProductsAndServices;
import com.example.bank.service.Impl.ProductsAndServicesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products-and-services")
public class ProductsAndServicesController {

    private final ModelMapper modelMapper;

    private final ProductsAndServicesServiceImpl productsAndServicesService;

    @GetMapping
    public List<ProductsAndServicesDTO> getAllProductsAndServices() {

        return productsAndServicesService.getAllProductsAndServices().stream().map(productsAndServices -> modelMapper.map(productsAndServices, ProductsAndServicesDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public ProductsAndServicesDTO getProductsAndServicesById(@PathVariable("id") Long id) {

        ProductsAndServices productsAndServices = productsAndServicesService.getProductsAndServicesById(id);
        ProductsAndServicesDTO productsAndServicesDTO = modelMapper.map(productsAndServices, ProductsAndServicesDTO.class);

        return productsAndServicesDTO;
    }

    @PostMapping
    public ProductsAndServicesDTO saveProductsAndServices(@RequestBody ProductsAndServicesDTO productsAndServicesDTO) {

        ProductsAndServices productsAndServicesPostRequest = modelMapper.map(productsAndServicesDTO, ProductsAndServices.class);
        ProductsAndServices productsAndServicesPostResponse = productsAndServicesService.saveOrUpdateProductsAndServices(productsAndServicesPostRequest);
        ProductsAndServicesDTO productsAndServicesDTOResponse = modelMapper.map(productsAndServicesPostResponse, ProductsAndServicesDTO.class);

        return productsAndServicesDTOResponse;
    }

    @PutMapping
    public ProductsAndServicesDTO updateProductsAndServices(@RequestBody ProductsAndServicesDTO productsAndServicesDTO) {

        ProductsAndServices productsAndServicesPostRequest = modelMapper.map(productsAndServicesDTO, ProductsAndServices.class);
        ProductsAndServices productsAndServicesPostResponse = productsAndServicesService.updateProductsAndServices(productsAndServicesPostRequest);
        ProductsAndServicesDTO productsAndServicesDTOResponse = modelMapper.map(productsAndServicesPostResponse, ProductsAndServicesDTO.class);

        return productsAndServicesDTOResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteProductsAndServices(@PathVariable(name = "id") Long id) {

        productsAndServicesService.deleteProductsAndServices(id);

        return "Product And Services deleted !";
    }
}
