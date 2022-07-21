package com.example.bank.repository;

import com.example.bank.entity.ProductsAndServices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductsAndServicesRepository extends CrudRepository <ProductsAndServices,Long> {
    @Override
    List<ProductsAndServices> findAll();
}
