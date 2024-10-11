package com.test.testBank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundWithdraw extends RuntimeException{
    public NotFoundWithdraw() {
    }

    public NotFoundWithdraw(String message) {
        super(message);
    }

    public NotFoundWithdraw(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundWithdraw(Throwable cause) {
        super(cause);
    }

    public NotFoundWithdraw(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
