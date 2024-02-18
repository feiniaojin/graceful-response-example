package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
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
public class UserInfoQuery {

    @NotNull(message = "userId is null !")
    private Long userId;

    @NotNull(message = "userName is null !")
    @Length(min = 6, max = 12)
    @ValidationStatusCode(code = "520")
    private String userName;

    @NotNull(message = "age is null !")
    @Range(min = 18, max = 50)
    private Integer age;
    @NotNull
    private Integer gender;
}
