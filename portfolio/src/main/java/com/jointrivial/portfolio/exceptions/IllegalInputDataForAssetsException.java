package com.jointrivial.portfolio.exceptions;

public class IllegalInputDataForAssetsException extends RuntimeException{
    public IllegalInputDataForAssetsException() {
        super();
    }
    public IllegalInputDataForAssetsException(String message, Throwable cause) {
        super(message, cause);
    }
    public IllegalInputDataForAssetsException(String message) {
        super(message);
    }
    public IllegalInputDataForAssetsException(Throwable cause) {
        super(cause);
    }
}
