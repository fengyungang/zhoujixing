package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
//统一收单线下交易预创建（扫码支付）
public class AlipayTradePrecreate {
    //商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
    private String out_trade_no;
    //卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
    private String seller_id;
    //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
    private BigDecimal total_amount;
    //可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】
    private BigDecimal discountable_amount;
    //订单标题
    private String subject;
    //订单包含的商品列表信息.json格式. 其它说明详见：“商品明细说明”
    private List<GoodsDetail> goods_detail;
    //对交易或商品的描述
    private String body;
    //商户操作员编号
    private String operator_id;
    //商户门店编号
    private String store_id;
    //禁用渠道，用户不可用指定渠道支付
    //当有多个渠道时用“,”分隔
    //注，与enable_pay_channels互斥
    //渠道列表：https://docs.open.alipay.com/common/wifww7
    private String disable_pay_channels;
    //可用渠道，用户只能在指定渠道范围内支付
    //当有多个渠道时用“,”分隔
    //注，与disable_pay_channels互斥
    //渠道列表
    private String enable_pay_channels;
    //商户机具终端编号
    private String terminal_id;
    //业务扩展参数
    private ExtendParams extend_params;
    //该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
    private String timeout_express;
    //描述结算信息，json格式，详见结算参数说明
    private SettleInfo settle_info;
    //商户原始订单号，最大长度限制32位
    private String merchant_order_no;
    //商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式
    private String business_params;
    //该笔订单允许的最晚付款时间，逾期将关闭交易，从生成二维码开始计时。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
    private String qr_code_timeout_express;


}
