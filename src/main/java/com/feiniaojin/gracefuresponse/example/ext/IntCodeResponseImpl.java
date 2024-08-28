package com.feiniaojin.gracefuresponse.example.ext;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feiniaojin.gracefulresponse.data.Response;
import com.feiniaojin.gracefulresponse.data.ResponseStatus;

/**
 * 将字符串的code适配为int
 *
 * @author qinyujie
 */
public class IntCodeResponseImpl implements Response {

    private final Response response;

    public IntCodeResponseImpl(Response response) {
        this.response = response;
    }

    @Override
    public void setStatus(ResponseStatus statusLine) {
        this.response.setStatus(statusLine);
    }

    @Override
    @JsonIgnore
    public ResponseStatus getStatus() {
        return this.response.getStatus();
    }

    @Override
    public void setPayload(Object payload) {
        this.response.setPayload(payload);
    }

    @Override
    @JsonIgnore
    public Object getPayload() {
        return this.response.getPayload();
    }

    public Integer getCode() {
        return Integer.valueOf(this.response.getStatus().getCode());
    }

    public String getMsg() {
        return this.response.getStatus().getMsg();
    }

    public Object getData() {
        return this.response.getPayload();
    }
}
