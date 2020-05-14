package com.feiniaojin.grh.example.service.impl;

import com.feiniaojin.grh.example.dto.RequestDto;
import com.feiniaojin.grh.example.dto.ResponseDto;
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

  @Override
  public ResponseDto getById(Long id) {

    ResponseDto dto = new ResponseDto();
    dto.setId(id);
    dto.setName("name" + id);
    return dto;
  }
}
