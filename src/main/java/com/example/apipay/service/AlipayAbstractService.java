package com.example.apipay.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.example.apipay.api.GeneralPayInterface;
import com.example.apipay.dto.AliPayParams;

/**
 * 支付宝
 * 进行联调支付宝
 */
public abstract class AlipayAbstractService extends
        BaseService implements GeneralPayInterface {

    /**
     * 手机网页支付
     *
     * @param params
     * @return
     * @throws AlipayApiException
     */
    public AlipayTradeWapPayResponse aliPaytradeWapPayRequest(AliPayParams params) throws AlipayApiException {
        AlipayTradeWapPayRequest alipayRequest = super.buildPublicRequestModel(AlipayTradeWapPayRequest.class);
        alipayRequest.setBizContent(JSON.toJSONString(params));
        AlipayTradeWapPayResponse response = alipayClient.pageExecute(alipayRequest);
        return response;
    }


}
