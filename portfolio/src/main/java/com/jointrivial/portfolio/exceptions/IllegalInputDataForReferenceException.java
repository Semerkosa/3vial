package com.jointrivial.portfolio.exceptions;

public class IllegalInputDataForReferenceException extends RuntimeException{
    public IllegalInputDataForReferenceException() {
        super();
    }
    public IllegalInputDataForReferenceException(String message, Throwable cause) {
        super(message, cause);
    }
    public IllegalInputDataForReferenceException(String message) {
        super(message);
    }
    public IllegalInputDataForReferenceException(Throwable cause) {
        super(cause);
    }
}
