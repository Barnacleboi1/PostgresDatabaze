package com.test.DatabazeOsobPostgres.Exception;

public class WrongIDFormatException extends RuntimeException{
    public WrongIDFormatException(String message) {
        super(message);
    }

    public WrongIDFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
