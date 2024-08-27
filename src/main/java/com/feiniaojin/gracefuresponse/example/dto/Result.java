package com.feiniaojin.gracefuresponse.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    private Integer resultCode;
    private String resultMsg;
}
