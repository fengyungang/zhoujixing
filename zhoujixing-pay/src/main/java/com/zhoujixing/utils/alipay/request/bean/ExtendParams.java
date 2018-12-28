package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
public class ExtendParams {
    //系统商编号
    //该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
    private String sys_service_provider_id;
    //行业数据回流信息, 详见：地铁支付接口参数补充说明
    private String industry_reflux_info;
    //卡类型
    private String card_type;
}
