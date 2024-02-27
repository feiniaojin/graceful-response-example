package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class InnerDto {
    @NotNull(message = "innerProperty is null !")
    @ValidationStatusCode(code = "522")
    private String innerProperty;
}
