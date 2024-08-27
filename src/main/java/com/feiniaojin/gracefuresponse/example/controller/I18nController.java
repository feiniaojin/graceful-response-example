package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.exceptions.I18nSampleException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i18n")
public class I18nController {

    @GetMapping("/test0")
    public void test0() {
        throw new I18nSampleException();
    }
}
