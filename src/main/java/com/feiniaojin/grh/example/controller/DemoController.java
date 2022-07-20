package com.feiniaojin.grh.example.controller;

import com.feiniaojin.grh.example.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @RequestMapping("/")
    public void exceptionMapper() {
        demoService.exceptionMapper();
    }

    @RequestMapping("/get")
    public Map<String,Object> get(){
        return demoService.get();
    }

}
