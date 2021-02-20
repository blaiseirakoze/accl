package com.volve.accl.exception;

public class HandlerBadRequestException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HandlerBadRequestException(String message) {
        super(message);
    }

    public HandlerBadRequestException(Throwable cause) {
        super(cause);
    }

    public HandlerBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}