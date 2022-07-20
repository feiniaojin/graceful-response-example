package com.feiniaojin.gracefuresponse.example.config;

import com.feiniaojin.gracefulresponse.api.DefaultResponseStatusFactory;
import com.feiniaojin.gracefulresponse.api.ResponseFactory;
import com.feiniaojin.gracefulresponse.data.Response;
import com.feiniaojin.gracefulresponse.data.ResponseStatus;

import javax.annotation.Resource;

public class CustomResponseFactoryImpl implements ResponseFactory<String> {

    @Resource
    private DefaultResponseStatusFactory<String> defaultResponseStatusFactory;

    @Override
    public Response<String> newEmptyInstance() {
        return new CustomResponseImpl();
    }

    @Override
    public Response<String> newInstance(ResponseStatus<String> statusLine) {
        CustomResponseImpl customResponse = new CustomResponseImpl();
        customResponse.setStatus(statusLine);
        return customResponse;
    }

    @Override
    public Response<String> newSuccessInstance() {
        CustomResponseImpl customResponse = new CustomResponseImpl();
        customResponse.setStatus(defaultResponseStatusFactory.defaultSuccess());
        return customResponse;
    }

    @Override
    public Response<String> newSuccessInstance(Object data) {
        Response<String> response = this.newSuccessInstance();
        response.setPayload(data);
        return response;
    }

    @Override
    public Response<String> newFailInstance() {
        CustomResponseImpl customResponse = new CustomResponseImpl();
        customResponse.setStatus(defaultResponseStatusFactory.defaultFail());
        return customResponse;
    }
}
