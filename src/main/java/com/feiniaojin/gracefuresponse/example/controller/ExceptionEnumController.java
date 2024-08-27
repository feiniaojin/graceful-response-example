package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefulresponse.GracefulResponse;
import com.feiniaojin.gracefuresponse.example.exceptions.ExceptionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常枚举的使用示例
 *
 * @author qinyujie
 */
@RestController
@RequestMapping("/enum")
public class ExceptionEnumController {

    @GetMapping("/test0")
    public void test0() {
        GracefulResponse.raiseException(ExceptionEnum.CUSTOM_EXCEPTION);
    }
}
