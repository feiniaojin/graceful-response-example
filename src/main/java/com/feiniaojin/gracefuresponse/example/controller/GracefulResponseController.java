package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefulresponse.GracefulResponse;
import com.feiniaojin.gracefulresponse.GracefulResponseDataException;
import com.feiniaojin.gracefuresponse.example.exceptions.ExceptionEnum;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/gr")
@Tag(name = "GracefulResponse工具类演示接口", description = "演示GracefulResponse工具类的使用")
public class GracefulResponseController {

    /**
     * 测试Controller中方法对参数进行校验的情形.
     * <a href="http://localhost:9090/gr/raiseException0">...</a>
     */
    @GetMapping("/raiseException0")
    public void raiseException0() {
        GracefulResponse.raiseException("520", "测试手工异常0");
    }

    /**
     * 测试Controller中方法对参数进行校验的情形.
     * <a href="http://localhost:9090/example/raiseException0">...</a>
     */
    @GetMapping("/raiseException1")
    public void raiseException1() {
        try {
            throw new Exception("发生异常啦");
        } catch (Exception e) {
            GracefulResponse.raiseException("1314", "测试手工异常1", e);
        }
    }

    @GetMapping("/assert0")
    public void assert0(Integer id) {
        Assert.isTrue(id == 1, "id不等于1");
    }

    @GetMapping("/assert1")
    public void assert1(Integer id) {
        GracefulResponse.wrapAssert(() -> Assert.isTrue(id == 1, "id不等于1"));
    }

    @GetMapping("/assert2")
    public void assert2(Integer id) {
        GracefulResponse.wrapAssert("1001", () -> Assert.isTrue(id == 1, "id不等于1"));
        Map<String, Object> data = new HashMap<>();
        GracefulResponse.wrapAssert("1001", data, () -> Assert.isTrue(id == 1, "id不等于1"));
    }

    @GetMapping("/dataException0")
    public void dataException0() {
        GracefulResponse.raiseException(ExceptionEnum.CUSTOM_EXCEPTION,
                new GracefulResponseDataException(Collections.singletonMap("key", "value")));
    }

    @GetMapping("/dataException")
    public void dataException() {
        throw new GracefulResponseDataException("测试dataException",Collections.singletonMap("key", "value"));
    }
}
