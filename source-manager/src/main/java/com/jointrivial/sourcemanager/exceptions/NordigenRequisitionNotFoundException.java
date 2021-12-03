package com.jointrivial.sourcemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NordigenRequisitionNotFoundException extends RuntimeException {

    public NordigenRequisitionNotFoundException() {
        super();
    }

    public NordigenRequisitionNotFoundException(String message) {
        super(message);
    }

}
