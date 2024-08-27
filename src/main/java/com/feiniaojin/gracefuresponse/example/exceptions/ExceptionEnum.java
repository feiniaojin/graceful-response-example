package com.feiniaojin.gracefuresponse.example.exceptions;

import com.feiniaojin.gracefulresponse.data.ResponseStatus;

/**
 * 异常枚举
 *
 * @author qinyujie
 */
public enum ExceptionEnum implements ResponseStatus {

    /**
     * 测试自定义的错误码
     */
    CUSTOM_EXCEPTION("520", "520自定义的异常");
    /**
     * 错误码
     */
    private final String code;
    /**
     * 异常信息
     */
    private final String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
