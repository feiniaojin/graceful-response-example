package com.feiniaojin.gracefuresponse.example.dto;

import lombok.Builder;
import lombok.Data;

/**
 * ResponseDto.
 *
 * @author <a href="mailto:943868899@qq.com">feiniaojin</a>
 * @date 2020/05/14
 */
@Data
@Builder
public class UserInfoView {
    private Long id;
    private String name;
}
