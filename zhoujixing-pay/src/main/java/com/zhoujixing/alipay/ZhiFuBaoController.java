package com.zhoujixing.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.aliyuncs.http.HttpRequest;
import com.aliyuncs.http.HttpResponse;
import com.google.gson.Gson;
import com.zhoujixing.utils.Result;
import com.zhoujixing.utils.alipay.code.CodeUtils;
import com.zhoujixing.utils.alipay.conf.AlipayConf;
import com.zhoujixing.utils.alipay.conn.AlipayTradeConn;
import com.zhoujixing.utils.alipay.conn.AlipayTradePagePayConn;
import com.zhoujixing.utils.alipay.conn.AlipayTradePrecreateConn;
import com.zhoujixing.utils.alipay.conn.AlipayTradeWapConn;
import com.zhoujixing.utils.alipay.request.bean.AlipayTradePagePay;
import com.zhoujixing.utils.alipay.request.bean.AlipayTradePay;
import com.zhoujixing.utils.alipay.request.bean.AlipayTradePrecreate;
import com.zhoujixing.utils.alipay.request.bean.AlipayTradeWapPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("alipay")
public class ZhiFuBaoController {

    @Autowired
    private AlipayTradeConn alipayTradeConn;
    @Autowired
    private AlipayTradeWapConn  alipayTradeWapConn;
    @Autowired
    private AlipayTradePrecreateConn alipayTradePrecreateConn;
    @Autowired
    private AlipayTradePagePayConn alipayTradePagePayConn;
    @Autowired
    private AlipayConf alipayConf;

    /**
     * 当面付：
     * 扫码付款接口
     * @param code 付款码
     * @param subject 订单主题
     * @param money 订单金额
     * @param appToken 授权码
     * @param seller_id 收款账号
     * @return
     * @throws AlipayApiException
     */
    @ResponseBody
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

    /**
     * 手机网站支付
     * @param httpResponse
     * @param subject 主题
     * @param total_amount 金额
     * @param returnUrl 支付完成返回地址
     * @param notifyUrl 异步回调地址
     * @param app_auth_token 授权码
     * @throws IOException
     * @throws AlipayApiException
     */
    @RequestMapping("webpay")
    public void webpay(HttpServletResponse httpResponse,String seller_id, String subject,String total_amount,String returnUrl,String notifyUrl,String app_auth_token) throws IOException, AlipayApiException {

        AlipayTradeWapPay alipayTradeWapPay = new AlipayTradeWapPay();
        alipayTradeWapPay.setSubject(subject);
        alipayTradeWapPay.setOut_trade_no(CodeUtils.getPayId());
        alipayTradeWapPay.setTotal_amount(new BigDecimal(total_amount));
        alipayTradeWapPay.setProduct_code("QUICK_WAP_WAY");
        alipayTradeWapPay.setSeller_id(seller_id);
        Gson gson= new Gson();
        AlipayTradeWapPayResponse response = alipayTradeWapConn.wapPay(gson.toJson(alipayTradeWapPay),returnUrl,notifyUrl,app_auth_token);
        String form = response.getBody();
        httpResponse.setContentType("text/html;charset= utf-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    /**
     * 当面付：
     * 收银员通过收银台或商户后台调用支付宝接口，生成二维码后，展示给用户，由用户扫描二维码完成订单支付。
     * @param seller_id 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
     * @param total_amount 订单总金额，单位为元，精确到小数点后两位
     * @param subject 订单标题
     */
    @ResponseBody
    @RequestMapping("precreatePay")
    public Result precreatePay(String seller_id, String total_amount, String subject, String app_auth_token) throws AlipayApiException {
        AlipayTradePrecreate alipayTradePrecreate = new AlipayTradePrecreate();
        alipayTradePrecreate.setOut_trade_no(CodeUtils.getPayId());
        alipayTradePrecreate.setSeller_id(seller_id);
        alipayTradePrecreate.setTotal_amount(new BigDecimal(total_amount));
        alipayTradePrecreate.setSubject(subject);
        Gson gson = new Gson();
        AlipayTradePrecreateResponse a = alipayTradePrecreateConn.precreatePay(gson.toJson(alipayTradePrecreate),app_auth_token);
        return Result.generate(0,"success",a);
    }

    /**
     * 电脑网站支付：PC场景下单并支付
     * @param httpResponse
     * @param total_amount 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * @param subject 订单标题
     * @param returnUrl 支付完成返回地址
     * @param notifyUrl 异步回调地址
     * @throws AlipayApiException
     * @throws IOException
     */
    @RequestMapping("pagePay")
    public void pagePay(HttpServletResponse httpResponse,String total_amount,String subject,String returnUrl,String notifyUrl,String app_auth_token) throws AlipayApiException, IOException {
        AlipayTradePagePay alipayTradePagePay = new AlipayTradePagePay();
        alipayTradePagePay.setOut_trade_no(CodeUtils.getPayId());
        alipayTradePagePay.setProduct_code("FAST_INSTANT_TRADE_PAY");
        alipayTradePagePay.setTotal_amount(new BigDecimal(total_amount));
        alipayTradePagePay.setSubject(subject);
        alipayTradePagePay.setReturn_url(alipayConf.getRETURN_URL());
        Gson gson = new Gson();
        AlipayTradePagePayResponse response = alipayTradePagePayConn.pagePay(returnUrl, notifyUrl, (gson.toJson(alipayTradePagePay)),app_auth_token);
        String form = response.getBody();
        httpResponse.setContentType("text/html;charset= utf-8");
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
        System.out.println(form);
    }

    /**
     * 电脑支付回调地址
     * @param response
     * @param request
     * @throws AlipayApiException
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("callbock")
    public void callbock(HttpResponse response, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayConf.getALIPAY_PUBLIC_KEY(), alipayConf.getCHARSET(), alipayConf.getSIGNTYPE()); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
        } else {
            System.out.println("验签失败");
        }
    }
}
