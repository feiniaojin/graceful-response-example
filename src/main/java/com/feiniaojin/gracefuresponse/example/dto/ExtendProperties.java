package com.feiniaojin.gracefuresponse.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExtendProperties {
    @NotNull(message = "扩展属性property1不能为空")
    private String property1;
}
