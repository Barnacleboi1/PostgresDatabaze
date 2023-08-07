package com.test.DatabazeOsobPostgres.Exception;

public class AlreadyInDatabaseException extends RuntimeException{
    public AlreadyInDatabaseException(String message) {
        super(message);
    }

    public AlreadyInDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
