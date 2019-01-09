package com.zhoujixing.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * 常用工具类的封装，md5,uuid等
 */
public class CommonUtils {


    /**
     * 生成 uuid， 即用来标识一笔单，也用做 nonce_str
     *
     * @return
     */
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString().
                replaceAll("-", "").substring(0, 32);

        return uuid;
    }


    /**
     * md5常用工具类
     *
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] array = md5.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        System.out.println(a.add(b));
    }
}