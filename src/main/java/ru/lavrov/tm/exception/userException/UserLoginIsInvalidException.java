package ru.lavrov.tm.exception.userException;

public class UserLoginIsInvalidException extends RuntimeException{
    private static final String message = "login is empty or null!";
    public UserLoginIsInvalidException() {
        super(message);
    }
    public UserLoginIsInvalidException(String message) {
        super(message);
    }
}
