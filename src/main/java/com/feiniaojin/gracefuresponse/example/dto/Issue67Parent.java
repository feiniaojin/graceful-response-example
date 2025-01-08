package com.feiniaojin.gracefuresponse.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Issue67Parent {

    @NotBlank(message = "编码不能为空")
    private String code;
}
