package com.example.apipay.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayRequest;
import com.example.apipay.dto.AliPayParams;
import com.example.apipay.exception.VerifyException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 基础的
 */
@Component
public class BaseService {
    @Autowired
    public AlipayClient alipayClient;

    //============================================================================
    //============================================================================
    //============================================================================
    @Value("${alipay.01.prodCode}")
    protected String prodCode;
    @Value("${alipay.01.notifyUrl}")
    protected String notifyUrl;
    @Value("${alipay.01.returnUrl}")
    protected String returnUrl;
    @Value("${alipay.01.SellerId}")
    protected String SellerId;
    @Value("${alipay.01.QuitUrl}")
    protected String QuitUrl;

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

    @SneakyThrows
    protected <T extends AlipayRequest> T buildRequestModel(Class<? extends AlipayRequest> request) {
        try {
            AlipayRequest reqeust = request.newInstance();
            reqeust.setProdCode(prodCode);
            reqeust.setNotifyUrl(notifyUrl);
            reqeust.setReturnUrl(returnUrl);
            return (T) reqeust;
        } catch (Exception e) {
            throw new VerifyException("请求异常");
        }
    }
    //============================================================================
    //============================================================================
    //============================================================================


}
