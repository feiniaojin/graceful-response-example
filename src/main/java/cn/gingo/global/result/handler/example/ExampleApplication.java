package cn.gingo.global.result.handler.example;

import cn.gingo.global.result.handler.EnableGlobalResultHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * class {@code ExampleApplication}  案例的入口类.
 * @author qinyujie
 * @version 0.1
 */
@EnableGlobalResultHandler
@SpringBootApplication
public class ExampleApplication {
  public static void main(String[] args) {
    SpringApplication.run(ExampleApplication.class, args);
  }
}
