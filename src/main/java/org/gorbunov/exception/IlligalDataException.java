package org.gorbunov.exception;

public class IlligalDataException extends RuntimeException{
    public IlligalDataException() {
    }

    public IlligalDataException(String message) {
        super(message);
    }

    public IlligalDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public IlligalDataException(Throwable cause) {
        super(cause);
    }

    public IlligalDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

