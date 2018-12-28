package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;
import sun.security.pkcs10.PKCS10;

import java.math.BigDecimal;

@Data
public class OpenApiRoyaltyDetailInfoPojo {
    //分账类型.
    //普通分账为：transfer;
    //补差为：replenish;
    //为空默认为分账transfer;
    private String royalty_type;
    //支出方账户。如果支出方账户类型为userId，本参数为支出方的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；如果支出方类型为loginName，本参数为支出方的支付宝登录号；
    private String trans_out;
    //支出方账户类型。userId表示是支付宝账号对应的支付宝唯一用户号;loginName表示是支付宝登录号；
    private String trans_out_type;
    //收入方账户类型。userId表示是支付宝账号对应的支付宝唯一用户号;cardSerialNo表示是卡编号;loginName表示是支付宝登录号；
    private String trans_in_type;
    //收入方账户。如果收入方账户类型为userId，本参数为收入方的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；如果收入方类型为cardSerialNo，本参数为收入方在支付宝绑定的卡编号；如果收入方类型为loginName，本参数为收入方的支付宝登录号；
    private String trans_in;
    //分账的金额，单位为元
    private BigDecimal amount;
    //分账信息中分账百分比。取值范围为大于0，少于或等于100的整数。
    private Integer amount_percentage;
    //分账描述
    private String desc;
}
