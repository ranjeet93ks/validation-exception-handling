package com.exception.handling.api.exception;

@SuppressWarnings("serial")
public class UserNotFoundException  extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
