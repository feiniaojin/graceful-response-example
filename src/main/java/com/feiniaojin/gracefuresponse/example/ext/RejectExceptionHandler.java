package com.feiniaojin.gracefuresponse.example.ext;

import com.feiniaojin.gracefuresponse.example.exceptions.ExcludeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Order(300)
public class RejectExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(RejectExceptionHandler.class);


    /**
     * 通过ResponseStatus指定最终的状态码
     * @param throwable
     * @return
     */
    @ExceptionHandler(value = ExcludeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> exceptionHandler(Throwable throwable) {
        logger.info("进入外部的RejectExceptionHandler处理逻辑");
        Map<String, Object> result = new HashMap<>();
        result.put("grace", "response");
        return result;
    }
}
