package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.dto.UserInfoView;
import com.feiniaojin.gracefuresponse.example.exceptions.ReplaceMsgException;
import com.feiniaojin.gracefuresponse.example.service.ExampleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * class {@code ExampleController} 使用案例的Controller.
 *
 * @author qinyujie
 */
@RestController
@RequestMapping("/em")
@Slf4j
@Validated
@Tag(name = "@ExceptionMapper注解案例接口", description = "演示@ExceptionMapper注解的使用")
public class ExceptionMapperController {

    @Resource
    private ExampleService exampleService;

    /**
     * 测试抛出运行时异常的处理.
     *
     * @return 直接返回，未处理
     */
    @GetMapping("/test0")
    public UserInfoView test0() {
        exampleService.testUnCheckedException();
        return UserInfoView.builder().id(0L).name("0000").build();
    }

    /**
     * 测试抛出运行时异常的处理.
     *
     * @return 直接返回，未处理
     */
    @GetMapping("/test1")
    public UserInfoView test1() throws Exception {
        exampleService.testCheckedException();
        return UserInfoView.builder().id(0L).name("0000").build();
    }

    @RequestMapping("/customExceptionDetailMessage0")
    public void customExceptionDetailMessage0() {
        throw new ReplaceMsgException();
    }

    @RequestMapping("/customExceptionDetailMessage1")
    public void customExceptionDetailMessage1() {
        throw new ReplaceMsgException("我自己定义了异常信息");
    }
}
