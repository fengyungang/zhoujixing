package com.zhoujixing.utils.alipay.conn;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*电脑网站支付
 */
@Component
public class AlipayTradePagePayConn {
    @Autowired
    private AlipayConf alipayConf;
    public AlipayTradePagePayResponse pagePay(
                        String returnUrl,String notifyUrl,String bizContent,String app_auth_token
                        ) throws AlipayApiException {
        AlipayClient alipayClient = alipayConf.aClient();
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);//在公共参数中设置回跳和通知地址
        alipayRequest.putOtherTextParam("app_auth_token",app_auth_token);
        alipayRequest.setBizContent(bizContent);//填充业务参数

            AlipayTradePagePayResponse response = alipayClient.pageExecute(alipayRequest);

        return response;
    }
}
