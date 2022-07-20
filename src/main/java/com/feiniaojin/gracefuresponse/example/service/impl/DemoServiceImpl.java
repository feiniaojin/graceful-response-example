package com.feiniaojin.gracefuresponse.example.service.impl;

import com.feiniaojin.gracefuresponse.example.exceptions.MapperDemoException;
import com.feiniaojin.gracefuresponse.example.service.DemoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public void exceptionMapper() {
        if(check()){
            //直接抛异常
            throw new MapperDemoException();
        }
        doSomething();
    }

    private void doSomething() {

    }

    private boolean check() {
        return true;
    }

    @Override
    public void exceptionAliasFor() {

    }

    @Override
    public Map<String, Object> get() {
        return null;
    }
}
