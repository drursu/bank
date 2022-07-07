package com.example.bank.service.Impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.Merchant;
import com.example.bank.repository.AccountRepository;
import com.example.bank.repository.MerchantRepository;
import com.example.bank.service.Interface.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    public Optional<Merchant> getMerchantById(Long id) {
        return merchantRepository.findById(id);
    }

    public Merchant saveOrUpdateMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
        return merchant;
    }

    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }

    public Merchant updateMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
        return merchant;
    }
}
