package com.feiniaojin.gracefuresponse.example.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.data.Response;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.data.ResponseStatus;

public class CustomResponseImpl implements Response {

    private String code;

    private String msg;

    private Object data;

    @Override
    public void setStatus(ResponseStatus statusLine) {
        this.code = statusLine.getCode();
        this.msg = statusLine.getMsg();
    }

    @Override
    @JsonIgnore
    public ResponseStatus getStatus() {
        return null;
    }

    @Override
    public void setPayload(Object payload) {
        this.data = payload;
    }

    @Override
    @JsonIgnore
    public Object getPayload() {
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
