package com.zhoujixing.utils.alipay.conn;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 手机网站支付
 */
@Component
public class AlipayTradeWapConn {
    @Autowired
    private AlipayConf alipayConf;

    /**
     * 手机网站支付
     * @param bizContent
     * @param returnUrl
     * @param notifyUrl
     * @return
     * @throws AlipayApiException
     */
    public AlipayTradeWapPayResponse wapPay(String bizContent,String returnUrl,String notifyUrl,String app_auth_token) throws AlipayApiException {
        AlipayClient alipayClient = alipayConf.aClient();
        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        request.setBizContent(bizContent);
        request.setReturnUrl(returnUrl);
        request.setNotifyUrl(notifyUrl);
        request.putOtherTextParam("app_auth_token",app_auth_token);
        AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);

        /*if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }*/
        return response;

    }

}
