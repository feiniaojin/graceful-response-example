package com.feiniaojin.gracefuresponse.example.exceptions.outer;

import com.feiniaojin.gracefulresponse.api.ExceptionAliasFor;

/**
 * 模拟外部异常
 *
 * @author qinyujie
 */
@ExceptionAliasFor(aliasFor = BbOuterException.class, code = "520", msg = "123", httpStatusCode = 500)
public class AliasOuterException extends RuntimeException {

    public AliasOuterException() {
    }

    public AliasOuterException(String message) {
        super(message);
    }

    public AliasOuterException(String message, Throwable cause) {
        super(message, cause);
    }

    public AliasOuterException(Throwable cause) {
        super(cause);
    }

    public AliasOuterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
