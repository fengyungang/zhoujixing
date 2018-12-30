package com.zhoujixing.utils.alipay.conf;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * 支付宝基础配置
 *
 */

@Configuration
@Data
@PropertySource(value = "classpath:alipay-application.properties")
public class AlipayConf {

    //appid
    @Value("${alipay.appid}")
    private String APPID;

    //公钥
    @Value("${alipay.RSA_PUBLIC_KEY}")
    private String RSA_PUBLIC_KEY;

    //私钥
    @Value("${alipay.RSA_PRIVATE_KEY}")
    private String RSA_PRIVATE_KEY;

    //异步回调地址
    @Value("${alipay.NOTIFY_URL}")
    private String NOTIFY_URL;

    //登录授权跳转地址
    @Value("${alipay.RETURN_URL}")
    private String RETURN_URL;

    //支付宝HTTPS请求地址
    @Value("${alipay.URL}")
    private String URL;

    //编码
    @Value("${alipay.CHARSET}")
    private String CHARSET;

    //数据格式（仅支持JSON）
    @Value("${alipay.FORMAT}")
    private String FORMAT;

    //支付宝公钥
    @Value("${alipay.ALIPAY_PUBLIC_KEY}")
    private String ALIPAY_PUBLIC_KEY;

    //加密方式
    @Value("${alipay.SIGNTYPE}")
    private String SIGNTYPE;

    @Override
    public String toString() {
        return "AlipayConf{" +
                "APPID='" + APPID + '\'' +
                ", RSA_PUBLIC_KEY='" + RSA_PUBLIC_KEY + '\'' +
                ", RSA_PRIVATE_KEY='" + RSA_PRIVATE_KEY + '\'' +
                ", NOTIFY_URL='" + NOTIFY_URL + '\'' +
                ", RETURN_URL='" + RETURN_URL + '\'' +
                ", URL='" + URL + '\'' +
                ", CHARSET='" + CHARSET + '\'' +
                ", FORMAT='" + FORMAT + '\'' +
                ", ALIPAY_PUBLIC_KEY='" + ALIPAY_PUBLIC_KEY + '\'' +
                ", SIGNTYPE='" + SIGNTYPE + '\'' +
                '}';
    }

    /**
     * 创建调用支付宝接口的链接
     * @return
     */
    public AlipayClient aClient() {
        AlipayClient alipayClient = new DefaultAlipayClient(URL, APPID, RSA_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGNTYPE);
        return alipayClient;
    }

}
