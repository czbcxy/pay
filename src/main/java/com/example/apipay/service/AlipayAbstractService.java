package com.example.apipay.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.example.apipay.api.GeneralPayInterface;
import com.example.apipay.dto.AliPayParams;
import com.example.apipay.utils.AliPayConfig;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

/**
 * 支付宝
 * 进行联调支付宝
 */
public abstract class AlipayAbstractService implements GeneralPayInterface {

    //============================================================================
    //============================================================================
    //============================================================================
    @Value("${alipay.01.prodCode}")
    private String prodCode;
    @Value("${alipay.01.notifyUrl}")
    private String notifyUrl;
    @Value("${alipay.01.returnUrl}")
    private String returnUrl;
    @Value("${alipay.01.SellerId}")
    private String SellerId;
    @Value("${alipay.01.QuitUrl}")
    private String QuitUrl;

    protected AliPayParams buildParamsModel(AliPayParams params) {
        //说明：商户网站唯一订单号
        params.setOut_trade_no(UUID.randomUUID().toString().toUpperCase());
        //说明：收款支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
        params.setSeller_id(SellerId);
        //说明：用户付款中途退出返回商户网站的地址
        params.setQuit_url(QuitUrl);
        //说明：销售产品码，商家和支付宝签约的产品码
        params.setProduct_code(prodCode);
        return params;
    }
    //============================================================================
    //============================================================================
    //============================================================================

    /**
     * 手机网页支付
     *
     * @param params
     * @return
     * @throws AlipayApiException
     */
    public AlipayTradeWapPayResponse aliPaytradeWapPayRequest(AliPayParams params) throws AlipayApiException {
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        alipayRequest.setBizContent(JSON.toJSONString(params));
        alipayRequest.setProdCode(prodCode);
        alipayRequest.setNotifyUrl(notifyUrl);
        alipayRequest.setReturnUrl(returnUrl);
        AlipayTradeWapPayResponse response =  AliPayConfig.getinstance().pageExecute(alipayRequest);
        return response;
    }


}
