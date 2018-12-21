package com.zhoujixing.controller;

import com.zhoujixing.config.KaptchaConfig;
import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.service.SysUserService;
import com.zhoujixing.entity.SysUserEntity;

import com.zhoujixing.shiro.JWTToken;
import com.zhoujixing.shiro.JWTUtil;
import com.zhoujixing.shiro.ResponseBean;
import com.zhoujixing.shiro.UnauthorizedException;
import com.zhoujixing.utils.IpUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private SysUserService userService;
    @Autowired
    private KaptchaConfig kaptchaConfig;



    @RequestMapping("/getUser")
    public String getUsers(){
        return "user";
    }


    @RequestMapping("/updateIP")

    public ResponseBean updateIP(@RequestParam("id") String id,
                                 @RequestParam("IP") String IP){
        Long b = Long.parseLong(id);
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setId(b);
        userEntity.setLastloginip(IP);
        int a= userService.updateIP(userEntity);
        if (a>0){
            return new ResponseBean(200,"更新成功",null);
        }else {
            return new ResponseBean(500,"更新失败",null);
        }
    }

    @RequestMapping("/register")
    @ApiOperation(value = "用户注册",notes = "用户注册功能")
    public ResponseBean register(HttpServletRequest request,@RequestParam("username") String username,@RequestParam("password") String password){
        SysUserEntity sysUserEntity = new SysUserEntity();
        String IP = IpUtil.getIP(request);//获取客户点的IP地址
        sysUserEntity.setLastloginip(IP);
        sysUserEntity.setLoginname(username);
        String pwd = JWTUtil.sha256(password);//给密码进行加密
        sysUserEntity.setLoginpass(pwd);
        int row = userService.addUser(sysUserEntity);
        if (row >0){
            return new ResponseBean(200,"注册成功",null);
        }else {
            return new ResponseBean(200,"注册失败",null);
        }
    }


    @RequestMapping("/addUser")
    @ApiOperation(value = "添加用户的方法",notes = "需要传用户所有信息")
    public String addUser(SysUserEntity userEntity){
        int a = userService.addUser(userEntity);
        if (a!=0){
            return "添加成功";
        }else {
            return "798";
        }
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    @ApiOperation(value = "获得所有用户的信息",notes = "默认获得所有用户的新")
    public List<SysUserEntity> getUserList(@RequestParam("page") int page,
                                           @RequestParam("rows") int rows){
        List<SysUserEntity> userEntities =userService.getPageUser(page,rows);
        return  userEntities;
    }

    @RequestMapping("/deleUser")
    @ApiOperation(value="删除",notes="用户删除操作")
    public String deleUser(@RequestParam("id") String id){
        long i=Long.parseLong(id);
        userService.deleteUser(i);
        return "redirect:getUser";

    }

    @RequestMapping("/findMenuByUserName")
    @ApiOperation(value = "查询该用户下的所有菜单")
    public List<SysMenuEntity> findMenuByUserName(@RequestParam("username") String username){
        List<SysMenuEntity> list = userService.findMenuByUserName(username);
        return list;
    }
    @RequestMapping("/getUsername")
    public ResponseBean getUsername(@RequestParam("username") String username){
        SysUserEntity sysUserEntity = userService.findByUserName(username);
        if (sysUserEntity != null){
            return new ResponseBean(502,"登录名称已经存在了",sysUserEntity);
        }else {
            return new ResponseBean(200,"登录名称可以使用",null);
        }
    }


}
