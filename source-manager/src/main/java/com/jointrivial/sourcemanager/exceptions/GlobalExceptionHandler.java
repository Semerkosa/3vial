package com.jointrivial.sourcemanager.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NordigenRequisitionNotFoundException.class)
    public ResponseStatusException handleRequisitionNotFoundException(NordigenRequisitionNotFoundException exception) {
        LOGGER.error("Requisition not found exception caught!", exception);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(NordigenAuthorizationException.class)
    public ResponseStatusException handleNordigenAuthorizationException(NordigenAuthorizationException exception) {
        LOGGER.error("Nordigen authoriztion exception caught!", exception);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseStatusException handleAllUncaughtException(Exception exception) {
        LOGGER.error("Unknown exception caught!", exception);
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
