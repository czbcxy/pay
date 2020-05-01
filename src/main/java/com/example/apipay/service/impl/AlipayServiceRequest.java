package com.example.apipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.example.apipay.dto.AliPayParams;
import com.example.apipay.service.AlipayAbstractService;
import org.springframework.stereotype.Component;

/**
 * 支付宝实现类
 * 进行本地业务实现类
 */
@Component
public class AlipayServiceRequest extends AlipayAbstractService {

    @Override
    public String tradeWapPayRequest(AliPayParams params) throws AlipayApiException {
        //公共参数
        params = super.buildPublicParamsModel(params);
        //其他参数 todo
        //params.setExt_user_info(......);
        AlipayTradeWapPayResponse response = super.aliPaytradeWapPayRequest(params);
        if (response.isSuccess()) {
            //做插库操作 todo 存储用户信息，商品信息，和订单id
            System.out.println(params.toString());
            return response.getBody();
        }
        return "支付失败"; // 支付错误跳转页面
    }
}
