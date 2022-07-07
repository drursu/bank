package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.ProductsAndServices;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.ProductsAndServicesRepository;
import com.example.bank.service.Interface.ProductsAndServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductsAndServicesServiceImpl implements ProductsAndServicesService {
    @Autowired
    ProductsAndServicesRepository productsAndServicesRepository;

    public List<ProductsAndServices> getAllProductsAndServices() {
        return productsAndServicesRepository.findAll();
    }

    public Optional<ProductsAndServices> getProductsAndServicesById(Long id) {
        return productsAndServicesRepository.findById(id);
    }

    public ProductsAndServices saveOrUpdateProductsAndServices(ProductsAndServices productsAndServices) {
        productsAndServicesRepository.save(productsAndServices);
        return productsAndServices;
    }

    public void deleteProductsAndServices(Long id) {
        productsAndServicesRepository.deleteById(id);
    }

    public ProductsAndServices updateProductsAndServices(ProductsAndServices productsAndServices) {
        productsAndServicesRepository.save(productsAndServices);
        return productsAndServices;
    }
}
