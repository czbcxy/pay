package com.example.apipay.factory;

import com.example.apipay.api.GeneralPayInterface;
import com.example.apipay.exception.VerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 支付客户端工厂
 */
@Component
public class PayClientFactory {
    //统一后缀，GeneralPayInterface的实现类必须是PayTypeEnum+GeneralPay组成
    private static final String SERVICE_SUFFIX = "ServiceRequest";

    @Autowired
    private Map<String, GeneralPayInterface> payCleint;

    public GeneralPayInterface getInstance(String type) throws VerifyException {
        GeneralPayInterface service = null;
        try {
            service = payCleint.get(type.toLowerCase() + SERVICE_SUFFIX);
        } catch (Exception e) {
            throw new VerifyException("支付方式错误");
        }
        return service;
    }
}
