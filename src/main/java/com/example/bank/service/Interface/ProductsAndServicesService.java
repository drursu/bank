package com.example.bank.service.Interface;

import com.example.bank.entity.ProductsAndServices;

import java.util.List;
import java.util.Optional;

public interface ProductsAndServicesService {
    public List<ProductsAndServices> getAllProductsAndServices();

    public Optional<ProductsAndServices> getProductsAndServicesById(Long id);

    public ProductsAndServices saveOrUpdateProductsAndServices(ProductsAndServices productsAndServices);

    public void deleteProductsAndServices(Long id);

    public ProductsAndServices updateProductsAndServices(ProductsAndServices productsAndServices);

}
