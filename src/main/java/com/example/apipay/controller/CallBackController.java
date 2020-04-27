package com.example.apipay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/callback")
public class CallBackController {

    @RequestMapping("/syncCallback")
    @ResponseBody
    public String syncCallback(HttpServletRequest dto) {
        String username = dto.getParameter("out_trade_no");
        String password = dto.getParameter("total_amount");
        //todo 校验之类 存库
        return "恭喜你，支付成功: 订单号：" + username + " <br> 支付金额：" + password;
    }
}
