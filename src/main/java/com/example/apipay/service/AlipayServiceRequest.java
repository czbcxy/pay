package com.example.apipay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.example.apipay.dto.AliPayParams;
import org.springframework.stereotype.Component;

/**
 * 支付宝实现类
 * 进行本地业务实现类
 */
@Component
public class AlipayServiceRequest extends AlipayAbstractService {

    @Override
    public String tradeWapPayRequest(AliPayParams params) throws AlipayApiException {
        params = super.buildParamsModel(params);
        AlipayTradeWapPayResponse response = super.aliPaytradeWapPayRequest(params);
        if (response.isSuccess()) {
            //做插库操作 todo
            System.out.println(params.toString());
            return response.getBody();
        }
        return "支付失败";
    }
}
