package com.zhoujixing.utils.alipay.conn;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付宝扫码支付
 */
@Component
public class AlipayTradeConn {

    @Autowired
    private AlipayConf alipayConf;

    /**
     *
     * 支付宝当面付付款接口，支持条形码和声波
     * @param app_auth_token
     * @param bizContent
     * @return
     * @throws AlipayApiException
     */
    public AlipayTradePayResponse pay(String app_auth_token,String bizContent) throws AlipayApiException {

        //打开连接
        AlipayClient alipayClient = alipayConf.aClient();
        //新建请求对象,然后把请求参数放到request里
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.putOtherTextParam("app_auth_token",app_auth_token);
        //设置请求参数
        request.setBizContent(bizContent);
        AlipayTradePayResponse response = alipayClient.execute(request);
        return response;

    }

}
