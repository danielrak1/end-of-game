package com.example.endofgame.exception;

public class DuplicateCategoryException extends BusinessException{

    public DuplicateCategoryException() {
    }

    public DuplicateCategoryException(String message) {
        super(message);
    }

    public DuplicateCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateCategoryException(Throwable cause) {
        super(cause);
    }

    public DuplicateCategoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
