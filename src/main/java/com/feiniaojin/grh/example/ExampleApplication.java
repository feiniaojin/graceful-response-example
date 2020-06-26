package com.feiniaojin.grh.example;

import com.feiniaojin.grh.starter.EnableGlobalResultHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * class {@code ExampleApplication}  案例的入口类.
 *
 * @author qinyujie
 * @version 0.1
 */
@EnableGlobalResultHandler
@SpringBootApplication
@EnableSwagger2
@Configuration
public class ExampleApplication {
  public static void main(String[] args) {
    SpringApplication.run(ExampleApplication.class, args);
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enable(true)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.feiniaojin.grh.example.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Demo api")
        .description("demo")
        .termsOfServiceUrl("http://localhost:9090/swagger-ui.html")
        .contact(
            new Contact("Swagger测试", "http://localhost:9090/swagger-ui.html", "943868899@qq.com"))
        .version("1.0")
        .build();
  }
}
