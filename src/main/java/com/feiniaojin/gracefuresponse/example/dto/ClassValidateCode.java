package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@ValidationStatusCode(code = "1500")
@Data
public class ClassValidateCode {
    @NotNull
    private Long id;
}
