package com.zhoujixing.demo;

import java.util.UUID;

public class UUIDUtils {
    /**
     * 生成文件名
     */

        public static String getUUID(String aaa) {
             //return 传入用户名称作为图片的名称
            //UUIDUtils.getUUID()随机数.toString显示成字符串.replace把-换成""字符
            //return UUID.randomUUID().toString().replace("-", "");
           return aaa;
        }
}