package com.feiniaojin.gracefuresponse.example.exceptions;

import com.feiniaojin.gracefulresponse.api.ExceptionMapper;

/**
 * @author qinyujie
 */
@ExceptionMapper(code = "999", msg = "中文的异常信息")
public class I18nSampleException extends RuntimeException {
}
