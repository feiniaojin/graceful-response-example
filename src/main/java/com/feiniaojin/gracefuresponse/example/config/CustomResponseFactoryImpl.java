package com.feiniaojin.gracefuresponse.example.config;


import com.feiniaojin.ddd.ecosystem.gracefulresponse.api.ResponseFactory;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.api.ResponseStatusFactory;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.data.Response;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.data.ResponseStatus;

import javax.annotation.Resource;

public class CustomResponseFactoryImpl implements ResponseFactory {

    @Resource
    private ResponseStatusFactory defaultResponseStatusFactory;

    @Override
    public Response newEmptyInstance() {
        return new CustomResponseImpl();
    }

    @Override
    public Response newInstance(ResponseStatus statusLine) {
        CustomResponseImpl customResponse = new CustomResponseImpl();
        customResponse.setStatus(statusLine);
        return customResponse;
    }

    @Override
    public Response newSuccessInstance() {
        CustomResponseImpl customResponse = new CustomResponseImpl();
        customResponse.setStatus(defaultResponseStatusFactory.defaultSuccess());
        return customResponse;
    }

    @Override
    public Response newSuccessInstance(Object data) {
        Response response = this.newSuccessInstance();
        response.setPayload(data);
        return response;
    }

    @Override
    public Response newFailInstance() {
        CustomResponseImpl customResponse = new CustomResponseImpl();
        customResponse.setStatus(defaultResponseStatusFactory.defaultFail());
        return customResponse;
    }
}
