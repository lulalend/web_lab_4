package ru.itmo.lab_4.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
}
