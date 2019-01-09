package com.zhoujixing.controller;


import com.zhoujixing.entity.SysCityEntity;
import com.zhoujixing.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    private SysCityService sysCityService;

    @ResponseBody
    @RequestMapping("/getCity")
    public List<SysCityEntity> getCity(SysCityEntity sysCityEntity){
        List<SysCityEntity> list = sysCityService.getCityList(sysCityEntity);
        return list;
    }

    /**
     * 用来判断是微信扫码还是支付宝扫码
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/pay")
    public String pay(HttpServletRequest request, HttpServletResponse response){
        String userAgent = request.getHeader("user-agent");
        if (userAgent != null && userAgent.contains("MicroMessenger")){
            System.out.println("微信支付");
        }else if (userAgent !=null && userAgent.contains("AlipayClient")){
            System.out.println("支付宝支付");
        }
        System.out.println(userAgent);
        return null;
    }


}
