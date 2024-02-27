package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class InnerDto {
    @NotNull(message = "innerProperty is null !")
    @ValidationStatusCode(code = "522")
    private String innerProperty;
}
