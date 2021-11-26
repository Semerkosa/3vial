package com.jointrivial.portfolio.exceptions;

public class IllegalInputCurrencyException extends RuntimeException{
    public IllegalInputCurrencyException() {
        super();
    }
    public IllegalInputCurrencyException(String message, Throwable cause) {
        super(message, cause);
    }
    public IllegalInputCurrencyException(String message) {
        super(message);
    }
    public IllegalInputCurrencyException(Throwable cause) {
        super(cause);
    }
}
