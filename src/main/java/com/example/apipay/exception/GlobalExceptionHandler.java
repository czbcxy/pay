package com.example.apipay.exception;

import com.alipay.api.AlipayApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * 全局异常类捕获接口
 *
 * @author czb
 * @date 2020年04月27日18:49:34
 */
@Slf4j
@ControllerAdvice(basePackages = {"com.example.apipay"})
public class GlobalExceptionHandler {

    /**
     * 所有全局异常捕获
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult allException() {
        return new ApiResult().setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * 服务io异常捕获
     *
     * @return
     */
    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ApiResult unAvailableException() {
        return new ApiResult().setCode(HttpStatus.SERVICE_UNAVAILABLE.value());
    }


    /**
     * 校验异常捕捉
     *
     * @return
     */
    @ExceptionHandler(VerifyException.class)
    public ApiResult VerifyException(String msg) {
        return new ApiResult().setCode(HttpStatus.BAD_REQUEST.value()).setMsg(msg);
    }

    /**
     * 支付异常捕捉
     *
     * @return
     */
    @ExceptionHandler(AlipayApiException.class)
    public ApiResult AlipayApiException() {
        return new ApiResult().setCode(HttpStatus.BAD_REQUEST.value()).setMsg("支付异常");
    }

}
