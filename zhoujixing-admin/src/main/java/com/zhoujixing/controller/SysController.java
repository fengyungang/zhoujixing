package com.zhoujixing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {
    /**
     * 调取登录页的方法
     * @return
     */
    @RequestMapping("/denglu")
    public String denglu(){
        return "denglu";
    }

    /**
     * 调取首页的方法
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 获取用户信息页面的方法
     * @return
     */
    @RequestMapping("/sysuser")
    public String sysuser(){
        return "admin/sysuser";
    }

    @RequestMapping("/zhuyao")
    public String zhuyao(){
        return "main";
    }

    @RequestMapping("/aadd")
    public String aadd(){
        return "add";
    }
}
