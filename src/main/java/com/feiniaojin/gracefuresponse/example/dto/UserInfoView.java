package com.feiniaojin.gracefuresponse.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "用户信息", description = "用户信息视图对象")
public class UserInfoView {
    @Schema(name = "id", description = "用户id", type = "long")
    private Long id;

    @Schema(description = "用户名", type = "string")
    private String name;
}
