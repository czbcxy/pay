package com.example.apipay.emun;

import lombok.Getter;

/**
 * 支付类别
 */
@Getter
public enum PayTypeEnum {
    aliPay,wechatPay,unionPay;
    private String value;

}
