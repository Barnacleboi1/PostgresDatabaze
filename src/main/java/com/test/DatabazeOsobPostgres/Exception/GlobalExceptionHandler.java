package com.test.DatabazeOsobPostgres.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                e,
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(message);
    }
    @ExceptionHandler(AlreadyInDatabaseException.class)
    public ResponseEntity<Object> handleAlreadyInDatabaseException(AlreadyInDatabaseException e) {

    }
}
