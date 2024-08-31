package com.feiniaojin.gracefuresponse.example.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 用户ID的校验
 */
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UserIdValidator.class)
@Documented
@ReportAsSingleViolation
public @interface UserId {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
