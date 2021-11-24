package com.jointrivial.portfolio.web.controller;

import com.jointrivial.portfolio.exceptions.IllegalInputCurrencyException;
import com.jointrivial.portfolio.exceptions.IllegalUserTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAdvice.class);

    @ExceptionHandler({IllegalInputCurrencyException.class})
    public ResponseStatusException handleInputCurrencyException(IllegalInputCurrencyException exception) {
        LOGGER.error("Illegal input currency exception caught", exception);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
    @ExceptionHandler({IllegalUserTokenException.class})
    public ResponseStatusException handleHelloException(IllegalInputCurrencyException exception) {
        LOGGER.error("Illegal user token exception caught", exception);
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}
