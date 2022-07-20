package com.feiniaojin.grh.example.config;

import com.feiniaojin.grh.example.exceptions.NotFoundException;
import com.feiniaojin.gracefulresponse.AbstractCustomConfig;
import com.feiniaojin.gracefulresponse.ExceptionAliasRegister;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GracefulResponseConfig extends AbstractCustomConfig {

    @Override
    protected void registerAlias(ExceptionAliasRegister register) {
        super.registerAlias(register);
        register.doRegisterExceptionAlias(NotFoundException.class);
    }
}
