package com.zhoujixing.wechat.controller;

import com.zhoujixing.wechat.utils.AesException;
import com.zhoujixing.wechat.utils.SHA1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class WechatPayController {


    @RequestMapping("/getBackUrl")
    @ResponseBody
    public String getBackUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");
        String token="fengyungang";//这里填基本配置中的token
        String jiami = "";
        try {
            jiami = SHA1.getSHA1(token,timestamp,nonce,"");
        } catch (AesException e) {
            e.printStackTrace();
        }
        System.out.println("加密"+jiami);
        System.out.println("本身"+signature);
        if (jiami.equals(signature)){
            return echostr;
        }else {
            return null;
        }
    }


}
