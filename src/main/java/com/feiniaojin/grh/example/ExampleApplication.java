package com.feiniaojin.grh.example;

import com.feiniaojin.naaf.gracefulresponse.EnableGracefulResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * class {@code ExampleApplication}  案例的入口类.
 *
 * @author qinyujie
 * @version 0.1
 */
@EnableGracefulResponse
@SpringBootApplication
@Configuration
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }


}
