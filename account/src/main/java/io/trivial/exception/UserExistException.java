package io.trivial.exception;

public class UserExistException extends Exception {
    public UserExistException(String errorMessage) {
        super(errorMessage);
    }
}
