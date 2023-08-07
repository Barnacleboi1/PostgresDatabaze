package com.test.DatabazeOsobPostgres.Exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ExceptionMessage {
    private String message;
    private HttpStatus statusCode;
    private ZonedDateTime timeStamp;

    public ExceptionMessage(String message, HttpStatus statusCode, ZonedDateTime timeStamp) {
        this.message = message;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
