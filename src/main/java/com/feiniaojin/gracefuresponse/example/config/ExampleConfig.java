package com.feiniaojin.gracefuresponse.example.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

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

//  @Override
//  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//    //自定义配置...
//    FastJsonConfig config = new FastJsonConfig();
//    config.setDateFormat("yyyy-MM-dd HH:mm:ss");
//    config.setReaderFeatures(JSONReader.Feature.FieldBased, JSONReader.Feature.SupportArrayToBean);
//    config.setWriterFeatures(JSONWriter.Feature.WriteMapNullValue, JSONWriter.Feature.PrettyFormat);
//    converter.setFastJsonConfig(config);
//    converter.setDefaultCharset(StandardCharsets.UTF_8);
//    converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//    converters.add(0, converter);
//  }


  @Override
  public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    WebMvcConfigurer.super.configureMessageConverters(converters);
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    WebMvcConfigurer.super.extendMessageConverters(converters);
  }
}
