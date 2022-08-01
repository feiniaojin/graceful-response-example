package com.feiniaojin.gracefuresponse.example.exceptions;

import com.feiniaojin.ddd.ecosystem.gracefulresponse.api.ExceptionAliasFor;
import org.springframework.web.client.HttpClientErrorException;

@ExceptionAliasFor(code = "1404",msg = "自定义异常信息",
        aliasFor = HttpClientErrorException.NotFound.class)
public class AliasDemoException extends RuntimeException{
}
