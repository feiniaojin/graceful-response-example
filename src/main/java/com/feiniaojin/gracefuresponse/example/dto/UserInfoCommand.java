package com.feiniaojin.gracefuresponse.example.dto;

import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class UserInfoCommand {
    @NotNull(message = "userId is null !")
    private Long userId;

    @NotNull(message = "userName is null !")
    @Length(min = 6, max = 12)
    @ValidationStatusCode(code = "520")
    private String userName;

    @NotNull(message = "extendProperties is null !")
    @Valid
    private ExtendProperties extendProperties;
}
