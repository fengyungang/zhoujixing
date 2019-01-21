package com.zhoujixing.wechat.smq;



import com.zhoujixing.utils.HttpUtils;
import com.zhoujixing.wechat.utils.CommonUtils;
import com.zhoujixing.wechat.utils.WXPayUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class BarcodeSaveToFile implements BarcodeSaveService {

    private Writer writer;
    /**
     * 关闭文件
     */
    @Override
    public void finish() {
        System.out.println("关闭文件");
        try {
            if (writer != null){
                writer.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 保存到文件
     * @param barcode
     */
    @Override
    public void save(String barcode) {
        try {
            System.out.println("打开文件");
            writer = new OutputStreamWriter(new FileOutputStream("d:/barcode.txt",true));
            SortedMap<String,String> params = new TreeMap<>();
            params.put("appid","wxfb5d9c9f082bce59");
            params.put("mch_id","1515223171");//商户号
            params.put("nonce_str", CommonUtils.generateUUID());//随机字符串
            params.put("body","盖浇饭测试");//商品描述
            params.put("out_trade_no","2019010549589");//商户订单号134599785825529203
            params.put("total_fee","1");//订单金额
            params.put("spbill_create_ip","20.45.110.103");//终端IP
            params.put("auth_code",barcode);
            String sing = WXPayUtil.createSign(params,"815389b9a6274be3b56f490164cf37d3" );
            params.put("sign",sing);//签名
            String payXml = WXPayUtil.mapToXml(params);
            System.out.println(payXml);
            String orderStr = HttpUtils.doPost("https://api.mch.weixin.qq.com/pay/micropay",
                    payXml,4000,4000,4000);
            if (null == orderStr){
                return;
            }
            Map<String,String> map = WXPayUtil.xmlToMap(orderStr);
            System.out.println(orderStr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
