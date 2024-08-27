package com.feiniaojin.gracefuresponse.example.exceptions;

/**
 * 用来测试异常放行的场景
 */
public class ExcludeException extends RuntimeException {
    public ExcludeException() {
    }

    public ExcludeException(String message) {
        super(message);
    }

    public ExcludeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcludeException(Throwable cause) {
        super(cause);
    }

    public ExcludeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
