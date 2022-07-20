package com.feiniaojin.gracefuresponse.example.service;

import com.feiniaojin.gracefuresponse.example.dto.ResponseDto;

/**
 * 测试Service接口.
 *
 * @author qinyujie
 */
public interface ExampleService {
  /**
   * 测试产生非受检异常的情形，即抛出运行时异常.
   */
  void testUnCheckedException();

  /**
   * 测试抛出受检异常的情况.
   *
   * @throws Exception 抛出受检异常
   */
  void testCheckedException() throws Exception;

  /**
   * 根据id获取数据.
   *
   * @param id  主键id.
   * @return
   */
  ResponseDto getById(Long id);
}
