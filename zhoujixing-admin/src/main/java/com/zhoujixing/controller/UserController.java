package com.zhoujixing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhoujixing.config.KaptchaConfig;
import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.service.SysUserService;
import com.zhoujixing.entity.SysUserEntity;

import com.zhoujixing.shiro.JWTToken;
import com.zhoujixing.shiro.JWTUtil;
import com.zhoujixing.shiro.ResponseBean;
import com.zhoujixing.shiro.UnauthorizedException;
import com.zhoujixing.utils.IpUtil;
import com.zhoujixing.utils.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public ResponseBean addUser(@RequestParam String user,HttpServletRequest request){
        ObjectMapper mapper = new ObjectMapper();
        SysUserEntity userEntity = null;
        try {
            userEntity= mapper.readValue(user,SysUserEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userEntity.setCreatetime(new Date());
        userEntity.setLastlogintime(new Date());
        String IP = IpUtil.getIP(request);
        userEntity.setLastloginip(IP);
        int a = userService.addUser(userEntity);
        if (a!=0){
            return new ResponseBean(200,"添加成功",null);
        }else {
            return new ResponseBean(500,"添加失败",null);
        }
    }

    @RequestMapping("/userupdate")
    @ResponseBody
    public ResponseBean  userUpdate(@RequestParam SysUserEntity userEntity){
        int a = userService.userUpdate(userEntity);
        if (a>0){
            return new ResponseBean(200,"更新成功",null);
        }else {
            return new ResponseBean(500,"更新失败",null);
        }
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public PageUtils getUserList(@RequestParam Map<String,Object> params){
        String page = (String) params.get("page");
        String rows = (String) params.get("limit");
        System.out.println(params);
        List<SysUserEntity> userEntities =userService.getPageUser(Integer.parseInt(page),Integer.parseInt(rows));
        int count = userService.count();
        PageUtils pageUtils =new PageUtils(userEntities,count,Integer.parseInt(rows),Integer.parseInt(page));
        return  pageUtils;
    }

    @RequestMapping("/deleUser")
    @ResponseBody
    public ResponseBean deleUser(@RequestParam String userid){
        long i=Long.parseLong(userid);
        int j = userService.deleteUser(i);
        if (j==1){
            return new ResponseBean(200,"删除成功",null);
        }else {
            return new ResponseBean(500,"删除失败",null);
        }


    }

    @RequestMapping("/findMenuByUserName")
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

    /**
     * 获得登录用户的信息
     * @param request
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public SysUserEntity getUserinfo(HttpServletRequest request){
        SysUserEntity sysUserEntity = (SysUserEntity) request.getSession().getAttribute("user");
        return sysUserEntity;
    }

    @RequestMapping("/password")
    public String password(@RequestParam("password") String password,@RequestParam("newPassword") String newPassword){
        if (newPassword == null || newPassword == ""){
            return "新密码不能为空";
        }
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setLoginpass(JWTUtil.sha256(password));
        SysUserEntity user = userService.findByUser(sysUserEntity);
        if (user != null){
            user.setLoginpass(JWTUtil.sha256(newPassword));
            int i = userService.updatepassword(user);
            return String.valueOf(i);
        }else {
            return "原密码不正确";
        }

    }
}
