package com.example.bank.service.Interface;

import com.example.bank.entity.Merchant;
import java.util.List;

public interface MerchantService {
    List<Merchant> getAllMerchants();

    Merchant getMerchantById(Long id);

    Merchant saveOrUpdateMerchant(Merchant merchant);

    void deleteMerchant(Long id);

    Merchant updateMerchant(Merchant merchant);

}
