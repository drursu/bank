package com.example.bank.controller;

import com.example.bank.entity.User;
import com.example.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users/{id}")
    @ResponseBody
    public ResponseEntity geUserById(@PathVariable Long id) {
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}/balance")
    @ResponseBody
    public ResponseEntity geUserBalance(@PathVariable Long id) {

        return new ResponseEntity(userRepository.findById(id).get().getBalance(),
                HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/users/{id}/accountNo")
    @ResponseBody
    public ResponseEntity getUserAccountNumber(@PathVariable Long id) {

        return new ResponseEntity(userRepository.findById(id).get().getAccountNumber(),
                HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User newUser) {

        userRepository.save(newUser);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
