package com.jointrivial.portfolio.exceptions;

public class IllegalUserTokenException extends RuntimeException {
    public IllegalUserTokenException() {
        super();
    }
    public IllegalUserTokenException(String message, Throwable cause) {
        super(message, cause);
    }
    public IllegalUserTokenException(String message) {
        super(message);
    }
    public IllegalUserTokenException(Throwable cause) {
        super(cause);
    }
}
