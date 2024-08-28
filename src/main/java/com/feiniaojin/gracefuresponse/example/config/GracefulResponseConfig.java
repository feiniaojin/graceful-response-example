package com.feiniaojin.gracefuresponse.example.config;

import com.feiniaojin.gracefulresponse.AbstractExceptionAliasRegisterConfig;
import com.feiniaojin.gracefulresponse.ExceptionAliasRegister;
import com.feiniaojin.gracefuresponse.example.exceptions.AliasDemoException;
import com.feiniaojin.gracefuresponse.example.exceptions.NotFoundException;
import com.feiniaojin.gracefuresponse.example.exceptions.outer.AliasOuterException;
import com.feiniaojin.gracefuresponse.example.ext.IntCodeResponseBodyAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GracefulResponseConfig extends AbstractExceptionAliasRegisterConfig {

    @Override
    protected void registerAlias(ExceptionAliasRegister aliasRegister) {
        aliasRegister.doRegisterExceptionAlias(NotFoundException.class);
        aliasRegister.doRegisterExceptionAlias(AliasOuterException.class);
    }

    @Bean
    public IntCodeResponseBodyAdvice intCodeResponseBodyAdvice() {
        return new IntCodeResponseBodyAdvice();
    }
}
