package com.feiniaojin.gracefuresponse.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExtendProperties {
    @NotNull(message = "扩展属性property1不能为空")
    private String property1;
}
