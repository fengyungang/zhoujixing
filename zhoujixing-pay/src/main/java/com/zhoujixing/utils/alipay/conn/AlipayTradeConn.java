package com.zhoujixing.utils.alipay.conn;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import org.springframework.stereotype.Component;

/**
 * 支付宝当面付接口连接
 */
@Component
public class AlipayTradeConn {

    public AlipayTradePayResponse pay(String app_auth_token,String bizContent) throws AlipayApiException {

        AlipayClient alipayClient = AlipayConf.aClient();
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.putOtherTextParam("app_auth_token",app_auth_token);
        request.setBizContent(bizContent);
        AlipayTradePayResponse response = alipayClient.execute(request);
        return response;
    }
}
