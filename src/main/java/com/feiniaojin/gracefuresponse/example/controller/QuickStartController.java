package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefulresponse.api.ResponseFactory;
import com.feiniaojin.gracefulresponse.data.Response;
import com.feiniaojin.gracefuresponse.example.dto.UserInfoQuery;
import com.feiniaojin.gracefuresponse.example.dto.UserInfoView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


/**
 * class {@code ExampleController} 使用案例的Controller.
 *
 * @author qinyujie
 */
@RestController
@RequestMapping("/qs")
@Slf4j
@Validated
@Tag(name = "快速入门", description = "Graceful Response基本使用")
public class QuickStartController {

    @Resource
    private ResponseFactory responseFactory;

    /**
     * 测试空返回值.
     * http://localhost:9090/qs/void
     */
    @GetMapping("/void")
    public void testVoidResponse() {
        log.info("testVoidResponse");
    }

    /**
     * 测试成功返回
     * http://localhost:9090/qs/get?id=1
     *
     * @param dto 入参
     * @return
     */
    @GetMapping("/get")
    @ApiResponse(responseCode = "200", description = "查询成功",
            content = @Content(schema = @Schema(implementation = UserInfoView.class)))
    @Operation(summary = "查询用户信息",
            description = "根据ID查询用户信息")
    public UserInfoView get(UserInfoQuery dto) {
        return UserInfoView.builder().id(dto.getUserId()).name("name" + dto.getUserId()).build();
    }

    /**
     * 测试抛出运行时异常的处理.
     * http://localhost:9090/qs/runtime
     *
     * @return 直接返回，未处理
     */
    @GetMapping("/runtime")
    public UserInfoView testRuntimeException() {
        throw new RuntimeException();
    }

    /**
     * 测试受检异常的情形.
     * http://localhost:9090/qs/checked
     *
     * @param dto 入参
     * @return 未处理，直接将入参返回
     * @throws Exception 受检异常
     */
    @GetMapping("/checked")
    public UserInfoView testCheckedException(UserInfoQuery dto) throws Exception {
        throw new Exception();
    }

    /**
     * 测试抛出{@code Throwable} 的情形.
     * http://localhost:9090/qs/throwable
     *
     * @param dto 入参
     * @return 未处理，直接返回
     * @throws Throwable 抛出Throwable异常
     */
    @GetMapping("/throwable")
    public UserInfoView testThrowable(UserInfoQuery dto) throws Throwable {
        log.info(dto.toString());
        throw new Throwable();
    }

    /**
     * http://localhost:9090/qs/jsonStr
     * <p>
     * {"key":"value"}
     * 测试Controller中方法对参数进行校验的情形.
     */
    @GetMapping("/jsonStr")
    public Response jsonStr() {
        return responseFactory.newSuccessInstance("abc");
    }

    /**
     * http://localhost:9090/qs/str
     * 直接返回String，将会匹配模版页面.
     */
    @GetMapping("/str")
    public String str() {
        log.info("");
        return "view";
    }

    /**
     * http://localhost:9090/example/return/str
     * 直接返回String
     */
    @GetMapping("/return/str")
    public String returnStr() {
        return "测试成功";
    }

    @GetMapping("/kv")
    public Map<String, Object> kv() {
        return Collections.singletonMap("key", "token");
    }

    /**
     * 不支持的http方法调用.
     * POST接口，使用GET进行请求
     * http://localhost:9090/example/methodPost
     *
     * @param userId 非空
     */
    @PostMapping(value = "/methodPost")
    public void testMethodNotSupport(Long userId) {
        log.info("收到入参userId={}", userId);
    }
}
