package com.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handleCarNotFoundException(CarNotFoundException carNotFoundException) {
        return new ResponseEntity<>("Car with given ID doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
