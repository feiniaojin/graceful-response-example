package com.feiniaojin.gracefuresponse.example.exceptions.outer;

import com.feiniaojin.gracefulresponse.api.ExceptionAliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 模拟外部异常
 *
 * @author qinyujie
 */
public class BbOuterException extends RuntimeException {

    public BbOuterException() {
        super();
    }

    public BbOuterException(String message) {
        super(message);
    }

    public BbOuterException(String message, Throwable cause) {
        super(message, cause);
    }

    public BbOuterException(Throwable cause) {
        super(cause);
    }

    protected BbOuterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
