package com.feiniaojin.grh.example.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger.web.UiConfiguration;

/**
 * Config类.
 *
 * @author Yujie
 * @version 1.0
 * @mail qinyujie@gingo.cn
 * @date 23/1/2020 20:18:00
 */
@Configuration
public class ExampleConfig implements WebMvcConfigurer {

  /**
   * 配置Validator的fail_fast.
   *
   * @return Validator
   */
  @Bean
  public Validator validator() {
    ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
        .configure()
        .addProperty("hibernate.validator.fail_fast", "true")
        .buildValidatorFactory();

    Validator validator = validatorFactory.getValidator();

    return validator;
  }

}
