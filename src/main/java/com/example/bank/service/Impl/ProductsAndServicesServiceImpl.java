package com.example.bank.service.Impl;

import com.example.bank.entity.ProductsAndServices;
import com.example.bank.exception.ResourceNotDeletedException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.exception.ResourceNotSavedException;
import com.example.bank.repository.ProductsAndServicesRepository;
import com.example.bank.service.Interface.ProductsAndServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsAndServicesServiceImpl implements ProductsAndServicesService {

    private final ProductsAndServicesRepository productsAndServicesRepository;

    public List<ProductsAndServices> getAllProductsAndServices() {
        return productsAndServicesRepository.findAll();
    }

    public ProductsAndServices getProductsAndServicesById(Long id) {

        return productsAndServicesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product or Service with id: " + id + " does not exist!"));
    }

    public ProductsAndServices saveOrUpdateProductsAndServices(ProductsAndServices productsAndServices) {

        try {
            productsAndServicesRepository.save(productsAndServices);

        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Product or Service could not be saved!");
        }

        return productsAndServices;
    }

    public void deleteProductsAndServices(Long id) {

        try {
            productsAndServicesRepository.deleteById(id);
        } catch (ResourceNotDeletedException exception) {
            throw new ResourceNotDeletedException("Product or Service could not be deleted!");
        }
    }

    public ProductsAndServices updateProductsAndServices(ProductsAndServices productsAndServices) {

        try {
            productsAndServicesRepository.save(productsAndServices);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Product or Service could not be updated!");
        }

        return productsAndServices;
    }
}
