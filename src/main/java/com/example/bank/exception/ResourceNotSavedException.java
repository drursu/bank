package com.example.bank.exception;

public class ResourceNotSavedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotSavedException(String msg) {
        super(msg);
    }
}
