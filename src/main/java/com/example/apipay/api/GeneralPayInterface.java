package com.example.apipay.api;

import com.alipay.api.AlipayApiException;
import com.example.apipay.dto.AliPayParams;
import org.springframework.stereotype.Service;

/**
 * 统一支付接口
 */
@Service
public interface GeneralPayInterface {

    /**
     * 手机网页支付
     */
    String tradeWapPayRequest(AliPayParams params) throws AlipayApiException;

}
