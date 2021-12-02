package com.jointrivial.sourcemanager.enums;

public enum ErrorMessages {

    NORDIGEN_AUTHENTICATION_FAILED("Nordigen authentication failed!"),
    NORDIGEN_REQUISITION_NOT_FOUND("Requisition not found!");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
