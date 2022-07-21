package com.example.bank.service.Impl;

import com.example.bank.entity.Merchant;
import com.example.bank.exception.ResourceNotDeletedException;
import com.example.bank.exception.ResourceNotFoundException;
import com.example.bank.exception.ResourceNotSavedException;
import com.example.bank.repository.MerchantRepository;
import com.example.bank.service.Interface.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    public Merchant getMerchantById(Long id) {

        return merchantRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Merchant with id: " + id + " does not exist!"));
    }

    public Merchant saveOrUpdateMerchant(Merchant merchant) {

        try {
            merchantRepository.save(merchant);

        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Merchant could not be saved!");
        }

        return merchant;
    }

    public void deleteMerchant(Long id) {

        try {
            merchantRepository.deleteById(id);
        } catch (ResourceNotDeletedException exception) {
            throw new ResourceNotDeletedException("Merchant could not be deleted!");
        }
    }

    public Merchant updateMerchant(Merchant merchant) {

        try {
            merchantRepository.save(merchant);
        } catch (ResourceNotSavedException exception) {
            throw new ResourceNotSavedException("Merchant could not be updated!");
        }

        return merchant;
    }
}
