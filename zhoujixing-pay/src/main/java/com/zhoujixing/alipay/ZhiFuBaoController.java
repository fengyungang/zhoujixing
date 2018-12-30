package com.zhoujixing.alipay;

import com.alipay.api.AlipayApiException;
import com.google.gson.Gson;
import com.zhoujixing.utils.alipay.code.CodeUtils;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import com.zhoujixing.utils.alipay.conn.AlipayTradeConn;
import com.zhoujixing.utils.alipay.request.bean.AlipayTradePay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("saoma1")
    public Object saoma1(String id) throws AlipayApiException {

        String a = "{" +
                "    \"out_trade_no\":\""+CodeUtils.getPayId()+"\"," +
                "    \"scene\":\"bar_code\"," +
                "    \"auth_code\":\""+id+"\"," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"timeout_express\":\"2m\"," +
                "    \"total_amount\":\"88.88\"" +
                "  }";
        Gson gson=new Gson();
        return gson.toJson( alipayTradeConn.pay(null,a));


    }

    @RequestMapping("saoma2")
    public Object saoma2(String id) throws AlipayApiException {

        AlipayTradePay alipayTradePay = new AlipayTradePay();
        //这里设置付款参数
        //付款码
        alipayTradePay.setAuth_code(id);
        //其他参数
        //设置订单号
        alipayTradePay.setOut_trade_no(CodeUtils.getPayId());
        //支付场景
        alipayTradePay.setScene("bar_code");
        //订单标题
        alipayTradePay.setSubject("黄金");
        //该笔订单允许的最晚付款时间
        alipayTradePay.setTimeout_express("2m");
        //金额
        alipayTradePay.setTotal_amount(new BigDecimal("100.00"));

        Gson gson=new Gson();
        //设置请求参数，并调用alipayTradeConn.pay(null,gson.toJson(alipayTradePay))
        return gson.toJson( alipayTradeConn.pay(null,gson.toJson(alipayTradePay)));
    }
    @RequestMapping("conf")
    public Object conf(){
        System.out.println(alipayConf.toString());
        return alipayConf;
    }
}
