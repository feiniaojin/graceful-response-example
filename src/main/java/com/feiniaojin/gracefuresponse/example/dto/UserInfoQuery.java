package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * 请求的DTO.
 *
 * @author qinyujie
 */
@Data
@Schema(name = "UserInfoQuery", description = "用户信息Query查询对象")
public class UserInfoQuery {

    @NotNull(message = "userId is null !")
    @Schema(name = "userId", description = "用户Id",type = "long")
    private Long userId;

    @NotNull(message = "userName is null !")
    @Length(min = 6, max = 12)
    @ValidationStatusCode(code = "520")
    @Schema(description = "用户名")
    private String userName;

    @NotNull(message = "age is null !")
    @Range(min = 18, max = 50)
    private Integer age;
    @NotNull
    private Integer gender;
}
