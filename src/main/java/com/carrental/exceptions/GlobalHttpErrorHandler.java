package com.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handleCarNotFoundException(CarNotFoundException carNotFoundException) {
        return new ResponseEntity<>("Car with given ID doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException clientNotFoundException) {
        return new ResponseEntity<>("Client with given ID doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<Object> handleDriverNotFoundException(DriverNotFoundException driverNotFoundException) {
        return new ResponseEntity<>("Driver with given ID doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarReleaseReportNotFoundException.class)
    public ResponseEntity<Object> handleCarReleaseReportNotFoundException(CarReleaseReportNotFoundException carReleaseReportNotFoundException) {
        return new ResponseEntity<>("Car release report with given ID doesn't exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarReturnReportNotFoundException.class)
    public ResponseEntity<Object> handleCarReturnReportNotFoundException(CarReturnReportNotFoundException carReturnReportNotFoundException) {
        return new ResponseEntity<>("Car return report with given ID doesn't exist)", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CarRentNotFoundException.class)
    public ResponseEntity<Object> handleCarRentNotFoundException(CarRentNotFoundException carRentNotFoundException) {
        return new ResponseEntity<>("Car rent with given ID doesn't exist)", HttpStatus.BAD_REQUEST);
    }
}
