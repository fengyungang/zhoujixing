package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
//	交易保障接口
public class MonitorHeartbeatSyn {
    //发送心跳的设备所依赖的支付宝产品，目前仅支持FP：当面付产品
    private String product;
    //发送心跳的设备类型：
    //CR——收银机；
    //STORE——门店；
    //VM——售卖
    private String type;
    //商户下唯一识别终端的标识。若发起方为收银机，可为收银机设备的ID，最短6位；如没有设备ID，可填MAC地址
    private String equipment_id;
    //产生心跳的时间，格式为：yyyy-MM-dd HH:mm:ss
    private String time;
    //门店ID。需要和交易接口中的门店ID保持一致。 如无门店ID，请填“DF”
    private String store_id;
    //pos设备连接的网络类型：2G、3G、WIFI、LAN。
    //LAN：有线网络
    private String network_type;
    //系统商的编号
    private String sys_service_provider_id;
    //Mac地址
    private String mac;
    //两次心跳时间内的交易相关信息。包括期间所有交易的商户订单号、耗时和状态。最多发送前30笔交易信息。json格式，具体参见下面的“交易性能信息参数说明”。
    //多笔交易按时间顺序直接拼接。
    //如果由于网络等原因心跳发送失败，则该交易性能信息本地继续累积，直到有心跳发送成功后，本地数据才可以清除。
    //此数据非常重要，有交易则必填
    private String trade_info;
    //心跳时间段内的机具异常原因，如有多个用“|”分隔。/
    //HE_PRINTER——打印机异常；
   //HE_SCANER——扫描枪异常；
   //HE_OTHER——其他硬件异常
    private String exception_info;
    //心跳信息发送方自定义，json格式
    private String extend_info;
}
