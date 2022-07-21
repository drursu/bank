package com.example.bank.controller;

import com.example.bank.DTO.MerchantDTO;
import com.example.bank.entity.Merchant;
import com.example.bank.service.Impl.MerchantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/merchants")
public class MerchantController {


    private final ModelMapper modelMapper;

    private final MerchantServiceImpl merchantService;

    @GetMapping
    public List<MerchantDTO> getAllMerchants() {

        return merchantService.getAllMerchants().stream().map(merchant -> modelMapper.map(merchant, MerchantDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public MerchantDTO getMerchantById(@PathVariable("id") Long id) {

        Merchant merchant = merchantService.getMerchantById(id);
        MerchantDTO merchantDTO = modelMapper.map(merchant, MerchantDTO.class);

        return merchantDTO;
    }

    @PostMapping
    public MerchantDTO saveMerchant(@RequestBody MerchantDTO merchantDTO) {

        Merchant merchantPostRequest = modelMapper.map(merchantDTO, Merchant.class);
        Merchant merchantPostResponse = merchantService.saveOrUpdateMerchant(merchantPostRequest);
        MerchantDTO merchantDTOResponse = modelMapper.map(merchantPostResponse, MerchantDTO.class);

        return merchantDTOResponse;
    }

    @PutMapping
    public MerchantDTO updateMerchant(@RequestBody MerchantDTO merchantDTO) {

        Merchant merchantPostRequest = modelMapper.map(merchantDTO, Merchant.class);
        Merchant merchantPostResponse = merchantService.updateMerchant(merchantPostRequest);
        MerchantDTO merchantDTOResponse = modelMapper.map(merchantPostResponse, MerchantDTO.class);

        return merchantDTOResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteMerchant(@PathVariable(name = "id") Long id) {
        merchantService.deleteMerchant(id);
        return "Merchant deleted !";
    }
}
