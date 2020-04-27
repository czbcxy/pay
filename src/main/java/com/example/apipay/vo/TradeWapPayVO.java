package com.example.apipay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TradeWapPayVO implements Serializable {
    private static final long serialVersionUID = 7479484156350536050L;

    //说明：商品的标题/交易标题/订单标题/订单关键字等。
    private String subject;

    //说明：订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
    private String total_amount;

    /**
     * 请求支付方式， aliPay,wechatPay,unionPay;
     */
    private String type;

}
