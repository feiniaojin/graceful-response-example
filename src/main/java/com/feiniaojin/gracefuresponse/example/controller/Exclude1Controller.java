package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.dto.Result;
import com.feiniaojin.gracefuresponse.example.exceptions.ExcludeException;
import com.feiniaojin.gracefuresponse.example.exceptions.excludep.PackageExcludeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exclude1")
@Slf4j
public class Exclude1Controller {

    @GetMapping("/test0")
    public Result test0() {
        log.info("Exclude1Controller#test0");
        return Result.builder().resultCode(100).resultMsg("100msg").build();
    }

    /**
     * 放行某个具体的异常
     *
     * @return
     */
    @GetMapping("/test1")
    public Result test1() {
        log.info("Exclude1Controller#test1");
        throw new ExcludeException("放行异常");
    }

    /**
     * 根据某个包路径放行异常
     *
     * @return
     */
    @GetMapping("/test2")
    public Result test2() {
        log.info("Exclude1Controller#test2");
        throw new PackageExcludeException("放行异常");
    }
}
