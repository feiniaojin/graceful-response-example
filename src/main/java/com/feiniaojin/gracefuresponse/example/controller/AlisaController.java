package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.exceptions.outer.OuterException;
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
    public void test0() {
        throw new OuterException();
    }
}
