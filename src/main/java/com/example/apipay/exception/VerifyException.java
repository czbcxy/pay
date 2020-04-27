package com.example.apipay.exception;

/**
 * 校验异常
 */
public class VerifyException extends Exception {
    /*无参构造函数*/
    public VerifyException() {
        super();
    }

    //用详细信息指定一个异常
    public VerifyException(String message) {
        super(message);
    }
}
