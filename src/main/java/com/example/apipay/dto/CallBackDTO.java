package com.example.apipay.dto;

import lombok.Data;

/**
 * 支付宝回调接口
 */
@Data
public class CallBackDTO {
    private String[] charset;
    private String[] out_trade_no;
    private String[] method;
    private String[] total_amount;
    private String[] sign;
    private String[] trade_no;
    private String[] auth_app_id;
    private String[] version;
    private String[] app_id;
    private String[] sign_type;
    private String[] seller_id;
    private String[] timestamp;
}
