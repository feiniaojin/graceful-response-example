package cn.gingo.global.result.handler.example.service.impl;

import cn.gingo.global.result.handler.example.exceptions.ExampleExceptions;
import cn.gingo.global.result.handler.example.service.ExampleService;
import org.springframework.stereotype.Service;

/**
 * 案例的Service实现.
 *
 * @author qinyujie
 */
@Service
public class ExampleServiceImpl implements ExampleService {

  public void testUnCheckedException() {
    throw new ExampleExceptions.UnCheckedException();
  }

  public void testCheckedException() throws Exception {
    throw new ExampleExceptions.CheckedException();
  }
}
