package com.example.bank.exception;

public class ResourceNotDeletedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotDeletedException(String msg) {
        super(msg);
    }
}
