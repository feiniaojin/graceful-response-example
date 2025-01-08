package com.feiniaojin.gracefuresponse.example.controller;

import com.feiniaojin.gracefuresponse.example.dto.Issue67Child;
import com.feiniaojin.gracefuresponse.example.dto.Issue67Parent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/issue67")
@RestController
@Slf4j
public class Issue67Controller {


    @RequestMapping("/command")
    public void command(@Validated @RequestBody Issue67Child child) {
        log.info("正常进行校验");
    }

    @RequestMapping("/parent")
    public void parent(@Validated @RequestBody Issue67Parent parent) {
        log.info("正常进行校验");
    }
}
