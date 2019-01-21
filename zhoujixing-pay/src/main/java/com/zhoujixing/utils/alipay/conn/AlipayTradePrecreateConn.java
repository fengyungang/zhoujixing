package com.zhoujixing.utils.alipay.conn;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 收银员通过收银台或商户后台调用支付宝接口，
 * 生成二维码后，展示给用户，
 * 由用户扫描二维码完成订单支付。
 */
@Component
public class AlipayTradePrecreateConn {
    @Autowired
    private AlipayConf alipayConf;
    public AlipayTradePrecreateResponse precreatePay(String bizContent,String app_auth_token) throws AlipayApiException {
        AlipayClient alipayClient = alipayConf.aClient();
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.putOtherTextParam("app_auth_token",app_auth_token);
        request.setBizContent(bizContent);
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        /*if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }*/
        return response;
    }
}
