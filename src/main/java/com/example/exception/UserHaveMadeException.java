package com.example.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserHaveMadeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UserHaveMadeException(String message) {
        super(message);
    }

    public UserHaveMadeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
