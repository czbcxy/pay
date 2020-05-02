package com.example.apipay.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Data
@Slf4j
@Component
@Configurable
public class AliPayConfig {

    private static Properties   properties;
    private static AlipayClient client = null;

    static {
        properties = new Properties();
        Config load  = ConfigFactory.load();
        String env   = load.getString("dev");
        Config load1 = ConfigFactory.load(env);
        properties.put("serverUrl", load1.getConfig("alipay").getString("serverUrl"));
        properties.put("appId", load1.getConfig("alipay").getString("appId"));
        properties.put("privateKey", load1.getConfig("alipay").getString("privateKey"));
        properties.put("format", load1.getConfig("alipay").getString("format"));
        properties.put("charset", load1.getConfig("alipay").getString("charset"));
        properties.put("alipayPublicKey", load1.getConfig("alipay").getString("alipayPublicKey"));
        properties.put("signType", load1.getConfig("alipay").getString("signType"));
        log.info("alipay param init successful" + properties.get("serverUrl"));
    }


    @Bean
    @Scope("singleton")
    public AlipayClient getClient() {
        return new DefaultAlipayClient(
                properties.getProperty("serverUrl"),
                properties.getProperty("appId"),
                properties.getProperty("privateKey"),
                properties.getProperty("format"),
                properties.getProperty("charset"),
                properties.getProperty("alipayPublicKey"),
                properties.getProperty("signType"));
    }

//    private static Object lock = new Object();
//    public static AlipayClient getinstance() {
//        if (Objects.isNull(client)) {
//            synchronized (lock) {
//                if (Objects.isNull(client)) {
//                    client = new DefaultAlipayClient(
//                            properties.getProperty("serverUrl"),
//                            properties.getProperty("appId"),
//                            properties.getProperty("privateKey"),
//                            properties.getProperty("format"),
//                            properties.getProperty("charset"),
//                            properties.getProperty("alipayPublicKey"),
//                            properties.getProperty("signType"));
//                }
//            }
//        }
//        return client;
//    }

}
