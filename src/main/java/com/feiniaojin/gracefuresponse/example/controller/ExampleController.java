package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.dto.UserInfoQuery;
import com.feiniaojin.gracefuresponse.example.dto.UserInfoView;
import com.feiniaojin.gracefuresponse.example.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;


/**
 * class {@code ExampleController} 使用案例的Controller.
 *
 * @author qinyujie
 */
@Controller
@RequestMapping("/example")
@Slf4j
@Validated
public class ExampleController {

    @Resource
    private ExampleService exampleService;

    /**
     * 测试空返回值.
     */
    @RequestMapping("/void")
    @ResponseBody
    public void testVoidResponse() {
        log.info("testVoidResponse");
    }

    /**
     * http://localhost:9090/example/validate
     *
     * @param dto
     */
    @RequestMapping("/validate")
    @ResponseBody
    public void testValidateException(@Validated UserInfoQuery dto) {
        log.info(dto.toString());
    }

    /**
     * http://localhost:9090/example/success?userId=1&userName=userName&age=20
     *
     * @param dto
     * @return
     */
    @RequestMapping("/success")
    @ResponseBody
    public UserInfoView testSuccess(@Validated UserInfoQuery dto) {
        log.info(dto.toString());
        return UserInfoView.builder().id(1L).name("name").build();
    }

    @RequestMapping("/get")
    @ResponseBody
    public UserInfoView get(Long id) {
        log.info("id=" + id);
        return UserInfoView.builder().id(id).name("name" + id).build();
    }

    /**
     * 测试抛出运行时异常的处理.
     *
     * @param dto 入参
     * @return 直接返回，未处理
     */
    @RequestMapping("/runtime")
    @ResponseBody
    public UserInfoView testRuntimeException(UserInfoQuery dto) {
        log.info(dto.toString());
        exampleService.testUnCheckedException();
        return UserInfoView.builder().id(0L).name("0000").build();
    }

    /**
     * 测试受检异常的情形.
     *
     * @param dto 入参
     * @return 未处理，直接将入参返回
     * @throws Exception 首检异常
     */
    @RequestMapping("/checked")
    @ResponseBody
    public UserInfoView testCheckedException(UserInfoQuery dto) throws Exception {
        log.info(dto.toString());
        exampleService.testCheckedException();
        return UserInfoView.builder().id(0L).name("0000").build();
    }

    /**
     * 测试抛出{@code Throwable} 的情形.
     *
     * @param dto 入参
     * @return 未处理，直接返回
     * @throws Throwable 抛出Throwable异常
     */
    @RequestMapping("/throwable")
    @ResponseBody
    public UserInfoView testThrowable(UserInfoQuery dto) throws Throwable {
        log.info(dto.toString());
        throw new Throwable();
    }

    /**
     * 测试Controller中方法对参数进行校验的情形.
     *
     * @param userId 非空
     */
    @RequestMapping("/method")
    @ResponseBody
    public void testMethod(@NotNull Long userId) {
        log.info("" + userId);

    }

    /**
     * 不支持的http方法调用.
     * POST接口，使用GET进行请求
     *
     * @param userId 非空
     */
    @RequestMapping(value = "/methodPost", method = RequestMethod.POST)
    @ResponseBody
    public void testMethodNotSupport(Long userId) {
        log.info("" + userId);

    }

    /**
     * 测试Controller中方法对参数进行校验的情形.
     */
    @RequestMapping("/jsonStr")
    @ResponseBody
    public String jsonStr() {
        log.info("");
        return "jsonStr";
    }

    /**
     * 测试Controller中方法对参数进行校验的情形.
     */
    @RequestMapping("/str")
    public String str() {
        log.info("");
        return "view";
    }
}
