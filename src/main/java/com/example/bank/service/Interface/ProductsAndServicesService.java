package com.example.bank.service.Interface;

import com.example.bank.entity.ProductsAndServices;
import java.util.List;

public interface ProductsAndServicesService {
    List<ProductsAndServices> getAllProductsAndServices();

    ProductsAndServices getProductsAndServicesById(Long id);

    ProductsAndServices saveOrUpdateProductsAndServices(ProductsAndServices productsAndServices);

    void deleteProductsAndServices(Long id);

    ProductsAndServices updateProductsAndServices(ProductsAndServices productsAndServices);

}
