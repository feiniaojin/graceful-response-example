package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefuresponse.example.validation.UserId;
import lombok.Data;

@Data
public class CustomValidationUserQuery {

    /**
     * 自定义的校验注解
     */
    @UserId(message = "用户账号不合法")
    private String userId;

    private String username;
}
