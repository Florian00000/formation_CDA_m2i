package org.example.error;

public class AccountAlreadyExist extends RuntimeException {
    public AccountAlreadyExist(String message) {
        super(message);
    }
}
