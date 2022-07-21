package com.example.bank.repository;

import com.example.bank.entity.CustomerPurchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerPurchaseRepository extends CrudRepository <CustomerPurchase,Long>{
    @Override
    List<CustomerPurchase> findAll();
}
