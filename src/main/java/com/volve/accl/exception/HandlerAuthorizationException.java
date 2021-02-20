package com.volve.accl.exception;

public class HandlerAuthorizationException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HandlerAuthorizationException(String message) {
        super(message);
    }

    public HandlerAuthorizationException(Throwable cause) {
        super(cause);
    }

    public HandlerAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

}