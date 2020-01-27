package cn.gingo.global.result.handler.example.controller;

import cn.gingo.global.result.handler.example.dto.RequestDto;
import cn.gingo.global.result.handler.example.service.ExampleService;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * class {@code ExampleController} 使用案例的Controller.
 *
 * @author qinyujie
 */
@Controller
@RequestMapping("/example")
@Slf4j
@Validated
public class ExampleController {

  @Resource
  private ExampleService exampleService;

  /**
   * 测试空返回值.
   */
  @RequestMapping("/void")
  @ResponseBody
  public void testVoidResponse() {

  }

  @RequestMapping("/validate")
  @ResponseBody
  public void testValidateException(@Validated RequestDto dto) {
    log.info(dto.toString());
  }

  @RequestMapping("/success")
  @ResponseBody
  public RequestDto testSuccess(@Validated RequestDto dto) {
    log.info(dto.toString());
    return dto;
  }

  /**
   * 测试抛出运行时异常的处理.
   *
   * @param dto 入参
   * @return 直接返回，未处理
   */
  @RequestMapping("/runtime")
  @ResponseBody
  public RequestDto testRuntimeException(@Validated RequestDto dto) {
    log.info(dto.toString());
    exampleService.testUnCheckedException();
    return dto;
  }

  /**
   * 测试受检异常的情形.
   *
   * @param dto 入参
   * @return 未处理，直接将入参返回
   * @throws Exception 首检异常
   */
  @RequestMapping("/checked")
  @ResponseBody
  public RequestDto testCheckedException(@Validated RequestDto dto) throws Exception {
    log.info(dto.toString());
    exampleService.testCheckedException();
    return dto;
  }

  /**
   * 测试抛出{@code Throwable} 的情形.
   *
   * @param dto 入参
   * @return 未处理，直接返回
   * @throws Throwable 抛出Throwable异常
   */
  @RequestMapping("/throwable")
  @ResponseBody
  public RequestDto testThrowable(@Validated RequestDto dto) throws Throwable {
    log.info(dto.toString());
    throw new Throwable();
  }

  /**
   * 测试Controller中方法对参数进行校验的情形.
   *
   * @param userId 非空
   */
  @RequestMapping("/method")
  @ResponseBody
  public void testMethod(@NotNull Long userId) {
    log.info("" + userId);

  }

  /**
   * 测试Controller中方法对参数进行校验的情形.
   */
  @RequestMapping("/str")
  @ResponseBody
  public String testString() {
    log.info("");
    return "testString";
  }
}
