package com.feiniaojin.gracefuresponse.example.config;

import com.feiniaojin.gracefulresponse.api.ResponseFactory;
import com.feiniaojin.gracefuresponse.example.exceptions.NotFoundException;
import com.feiniaojin.gracefulresponse.AbstractCustomConfig;
import com.feiniaojin.gracefulresponse.ExceptionAliasRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GracefulResponseConfig extends AbstractCustomConfig {

    @Override
    protected void registerAlias(ExceptionAliasRegister register) {
        super.registerAlias(register);
        register.doRegisterExceptionAlias(NotFoundException.class);
    }

    @Bean
    public ResponseFactory<String> responseFactory() {
        return new CustomResponseFactoryImpl();
    }
}
