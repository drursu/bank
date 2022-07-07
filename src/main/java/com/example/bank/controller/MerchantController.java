package com.example.bank.controller;

import com.example.bank.DTO.MerchantDTO;
import com.example.bank.entity.Merchant;
import com.example.bank.service.Impl.MerchantServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    MerchantServiceImpl merchantService;

    @GetMapping
    public List<MerchantDTO> getAllMerchants() {

        return merchantService.getAllMerchants().stream().map(merchant -> modelMapper.map(merchant, MerchantDTO.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public Optional<MerchantDTO> getMerchantById(@PathVariable("id") Long id) {

        Optional<Merchant> merchant = merchantService.getMerchantById(id);
        MerchantDTO merchantDTO = modelMapper.map(merchant, MerchantDTO.class);

        return Optional.ofNullable(merchantDTO);
    }

    @PostMapping
    public ResponseEntity<MerchantDTO> saveMerchant(@RequestBody MerchantDTO merchantDTO) {

        Merchant merchantPostRequest = modelMapper.map(merchantDTO,Merchant.class);
        Merchant merchantPostResponse = merchantService.saveOrUpdateMerchant(merchantPostRequest);
        MerchantDTO merchantDTOResponse = modelMapper.map(merchantPostResponse,MerchantDTO.class);

        return new ResponseEntity<>(merchantDTOResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MerchantDTO> updateMerchant(@RequestBody MerchantDTO merchantDTO) {

        Merchant merchantPostRequest = modelMapper.map(merchantDTO, Merchant.class);
        Merchant merchantPostResponse = merchantService.updateMerchant(merchantPostRequest);
        MerchantDTO merchantDTOResponse = modelMapper.map(merchantPostResponse,MerchantDTO.class);

        return ResponseEntity.ok().body(merchantDTOResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMerchant(@PathVariable(name = "id") Long id){
        merchantService.deleteMerchant(id);
        return new ResponseEntity<>("Merchant deleted !", HttpStatus.OK);
    }
}
