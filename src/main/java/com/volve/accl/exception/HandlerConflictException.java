package com.volve.accl.exception;

public class HandlerConflictException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HandlerConflictException(String message) {
        super(message);
    }

    public HandlerConflictException(Throwable cause) {
        super(cause);
    }

    public HandlerConflictException(String message, Throwable cause) {
        super(message, cause);
    }

}