package com.example.bank.service.Interface;

import com.example.bank.entity.Merchant;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    public List<Merchant> getAllMerchants();

    public Optional<Merchant> getMerchantById(Long id);

    public Merchant saveOrUpdateMerchant(Merchant merchant);

    public void deleteMerchant(Long id);

    public Merchant updateMerchant(Merchant merchant);

}
