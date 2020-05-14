package com.feiniaojin.grh.example.service.impl;

import com.feiniaojin.grh.example.exceptions.ExampleExceptions;
import com.feiniaojin.grh.example.service.ExampleService;
import org.springframework.stereotype.Service;

/**
 * 案例的Service实现.
 *
 * @author qinyujie
 */
@Service
public class ExampleServiceImpl implements ExampleService {

  @Override
  public void testUnCheckedException() {
    throw new ExampleExceptions.UnCheckedException();
  }
  @Override
  public void testCheckedException() throws Exception {
    throw new ExampleExceptions.CheckedException();
  }
}
