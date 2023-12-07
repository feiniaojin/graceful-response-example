package com.feiniaojin.gracefuresponse.example.exceptions;

import com.feiniaojin.gracefulresponse.api.ExceptionMapper;

@ExceptionMapper(code = "1007", msg = "有内鬼，终止交易", msgReplaceable = true)
public class RatException extends RuntimeException {
    public RatException() {
    }

    public RatException(String message) {
        super(message);
    }

    public RatException(String message, Throwable cause) {
        super(message, cause);
    }

    public RatException(Throwable cause) {
        super(cause);
    }

    public RatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
