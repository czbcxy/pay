package com.example.apipay.controller;

import com.alipay.api.AlipayApiException;
import com.example.apipay.api.GeneralPayInterface;
import com.example.apipay.dto.AliPayParams;
import com.example.apipay.factory.PayClientFactory;
import com.example.apipay.factory.VerifyException;
import com.example.apipay.vo.TradeWapPayVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlipayController {

    @Autowired
    private PayClientFactory PayClientFactory;

    @RequestMapping("/tradeWapPay")
    @ResponseBody
    public String tradeWapPay(TradeWapPayVO vo) throws AlipayApiException, VerifyException {
        AliPayParams params = new AliPayParams();
        BeanUtils.copyProperties(vo,params);
        GeneralPayInterface alipay = PayClientFactory.getInstance(vo.getType());
        return alipay.tradeWapPayRequest(params);
    }
}