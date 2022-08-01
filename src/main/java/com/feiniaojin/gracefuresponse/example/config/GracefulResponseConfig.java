package com.feiniaojin.gracefuresponse.example.config;

import com.feiniaojin.ddd.ecosystem.gracefulresponse.AbstractExceptionAliasRegisterConfig;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.ExceptionAliasRegister;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.api.ResponseFactory;
import com.feiniaojin.gracefuresponse.example.exceptions.NotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GracefulResponseConfig extends AbstractExceptionAliasRegisterConfig {

    @Override
    protected void registerAlias(ExceptionAliasRegister aliasRegister) {
        aliasRegister.doRegisterExceptionAlias(NotFoundException.class);
    }

    @Bean
    public ResponseFactory responseFactory() {
        return new CustomResponseFactoryImpl();
    }
}
