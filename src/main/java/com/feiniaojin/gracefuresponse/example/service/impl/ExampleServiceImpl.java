package com.feiniaojin.gracefuresponse.example.service.impl;

import com.feiniaojin.gracefuresponse.example.exceptions.ExampleExceptions;
import com.feiniaojin.gracefuresponse.example.service.ExampleService;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    @Override
    public void testUnCheckedException() {
        throw new ExampleExceptions.UnCheckedException();
    }

    @Override
    public void testCheckedException() throws Exception {
        throw new Exception();
    }

}
