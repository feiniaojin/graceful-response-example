package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.dto.UserInfoView;
import com.feiniaojin.gracefuresponse.example.exceptions.outer.BbOuterException;
import com.feiniaojin.gracefuresponse.example.exceptions.outer.OuterException;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异常别名的用法示例
 *
 * @author qinyujie
 */
@RestController
@RequestMapping("/alias")
public class AlisaController {

    /**
     * 模拟抛出一个外部异常的场景
     */
    @GetMapping("/test0")
    @ApiResponse(responseCode = "401", description = "查询成功",
            content = @Content(schema = @Schema(implementation = UserInfoView.class)))
    public void test0() {
        throw new OuterException();
    }

    /**
     * 模拟抛出一个外部异常的场景
     */
    @GetMapping("/test1")
    @ApiResponse(responseCode = "500", description = "查询成功",
            content = @Content(schema = @Schema(implementation = UserInfoView.class)))
    public void test1() {
        throw new BbOuterException();
    }
}
