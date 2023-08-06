package com.test.DatabazeOsobPostgres.Exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Date;

public class ExceptionMessage {
    private String message;
    private Throwable throwable;
    private HttpStatus statusCode;
    private ZonedDateTime timeStamp;

    public ExceptionMessage(String message, Throwable throwable, HttpStatus statusCode, ZonedDateTime timeStamp) {
        this.message = message;
        this.throwable = throwable;
        this.statusCode = statusCode;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
