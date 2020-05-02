package com.example.apipay.controller;

import com.alibaba.fastjson.JSON;
import com.example.apipay.dto.CallBackDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/callback")
public class CallBackController {

    @RequestMapping("/syncCallback")
    @ResponseBody
    public String syncCallback(HttpServletRequest dto) {
        Map<String, String[]> parameterMap = dto.getParameterMap();
        String                jsonString   = JSON.toJSONString(parameterMap);
        CallBackDTO           callBackDTO  = JSON.parseObject(jsonString, CallBackDTO.class);
        //同步回调 todo 利用订单id，查询数据库刚才支付的信息，更新支付详情、、、、
        String username = dto.getParameter("out_trade_no");
        String password = dto.getParameter("total_amount");
        //返回用户跳转页面，一般是带上支付信息。
        return "恭喜你，支付成功: 订单号：" + username + " <br> 支付金额：" + password +
                "</br>支付宝回调参数，json格式" + jsonString +
                "</br>支付宝回调参数，对象格式" + callBackDTO.toString();
    }

    /**
     * 异步回调信息
     *
     * @param dto
     * @return
     */
    @RequestMapping("/asyncCallback")
    @ResponseBody
    public void asyncCallback(HttpServletRequest dto) {
        Map<String, String[]> parameterMap = dto.getParameterMap();
        String                jsonString   = JSON.toJSONString(parameterMap);
        CallBackDTO           callBackDTO  = JSON.parseObject(jsonString, CallBackDTO.class);
        //异步回调 todo 利用订单id，查询数据库刚才支付的信息，更新支付详情、、、、
    }
}
