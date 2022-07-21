package com.example.bank.repository;

import com.example.bank.entity.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MerchantRepository extends CrudRepository <Merchant,Long> {
    @Override
    List<Merchant> findAll();
}
