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
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AlreadyInDatabaseException.class)
    public ResponseEntity<Object> handleAlreadyInDatabaseException(AlreadyInDatabaseException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(WrongIDFormatException.class)
    public ResponseEntity<Object> handleWrongIDFormatException(WrongIDFormatException e) {
        ExceptionMessage message = new ExceptionMessage(
                e.getMessage(),
                HttpStatus.NOT_ACCEPTABLE,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }
}
