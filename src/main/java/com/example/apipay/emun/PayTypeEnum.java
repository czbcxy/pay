package com.example.apipay.emun;

import lombok.Getter;

/**
 * 支付类别
 */
@Getter
public enum PayTypeEnum {
    aliPay,wechatPay,unionPay,any;
    private String value;

    public static void setValue(String type) {
        any.value = type;
    }
}
