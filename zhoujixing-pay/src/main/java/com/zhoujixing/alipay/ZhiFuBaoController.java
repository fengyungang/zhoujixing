package com.zhoujixing.alipay;

import com.alipay.api.AlipayApiException;
import com.google.gson.Gson;
import com.zhoujixing.utils.alipay.code.CodeUtils;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import com.zhoujixing.utils.alipay.conn.AlipayTradeConn;
import com.zhoujixing.utils.alipay.request.bean.AlipayTradePay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("alipay")
public class ZhiFuBaoController {

    @Autowired
    private AlipayTradeConn alipayTradeConn;

    @Autowired
    private AlipayConf alipayConf;

    /**
     * 扫码付款接口
     * @param code 付款码
     * @param subject 订单主题
     * @param money 订单金额
     * @param appToken 授权码
     * @param seller_id 收款账号
     * @return
     * @throws AlipayApiException
     */
    @RequestMapping("saoma")
    public Object saoma(String code,String subject,String money,String appToken,String seller_id) throws AlipayApiException {

        AlipayTradePay alipayTradePay = new AlipayTradePay();
        //这里设置付款参数
        //付款码
        alipayTradePay.setAuth_code(code);
        //其他参数
        //设置订单号
        alipayTradePay.setOut_trade_no(CodeUtils.getPayId());
        //支付场景
        alipayTradePay.setScene("bar_code");
        //订单标题
        alipayTradePay.setSubject(subject);
        //该笔订单允许的最晚付款时间
        alipayTradePay.setTimeout_express("2m");
        //金额
        alipayTradePay.setTotal_amount(new BigDecimal(money));
        //收款账号
        alipayTradePay.setSeller_id(seller_id);
        Gson gson=new Gson();
        //设置请求参数，并调用
        return gson.toJson( alipayTradeConn.pay(appToken,gson.toJson(alipayTradePay)));
    }

}
