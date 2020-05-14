package com.feiniaojin.grh.example.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * 请求的DTO.
 *
 * @author qinyujie
 */
@Data
public class RequestDto {

  @NotNull(message = "userId is null !")
  private Long userId;

  @NotNull(message = "userName is null !")
  @Length(min = 6, max = 12)
  private String userName;

  @NotNull(message = "age is null !")
  @Range(min = 18, max = 50)
  private Integer age;
}
