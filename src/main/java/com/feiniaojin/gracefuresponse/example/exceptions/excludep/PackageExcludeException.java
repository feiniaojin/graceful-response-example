package com.feiniaojin.gracefuresponse.example.exceptions.excludep;

/**
 * 根据包路径进行放行
 *
 * @author qinyujie
 */
public class PackageExcludeException extends RuntimeException {

    public PackageExcludeException() {
    }

    public PackageExcludeException(String message) {
        super(message);
    }

    public PackageExcludeException(String message, Throwable cause) {
        super(message, cause);
    }

    public PackageExcludeException(Throwable cause) {
        super(cause);
    }

    public PackageExcludeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
