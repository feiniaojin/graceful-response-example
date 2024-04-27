package com.feiniaojin.gracefuresponse.example.controller.exclude;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/ex")
public class ExController {

    @RequestMapping("/sample0")
    public Map<String,Object> sample0(){
        return Collections.singletonMap("key","value");
    }
}
