package com.volve.accl.exception;

public class HandlerInternalServerErrorException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public HandlerInternalServerErrorException(String message) {
        super(message);
    }

    public HandlerInternalServerErrorException(Throwable cause) {
        super(cause);
    }

    public HandlerInternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}