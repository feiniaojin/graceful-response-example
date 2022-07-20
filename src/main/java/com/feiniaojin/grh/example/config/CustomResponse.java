package com.feiniaojin.grh.example.config;

import com.feiniaojin.gracefulresponse.data.NaafResponse;
import com.feiniaojin.gracefulresponse.data.NaafResponseStatus;

public class CustomResponse implements NaafResponse {

    @Override
    public void setStatus(NaafResponseStatus statusLine) {

    }

    @Override
    public NaafResponseStatus<String> getStatus() {
        return null;
    }

    @Override
    public void setPayload(Object payload) {

    }

    @Override
    public Object getPayload() {
        return null;
    }
}
