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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@RestController
public class UserController {


    @Autowired
    private SysUserService userService;
    @Autowired
    private KaptchaConfig kaptchaConfig;



    @RequestMapping("/defaultKaptcha")
    @ApiOperation(value = "获取验证的方法")
    public void defaultKaptcha(HttpServletRequest request,HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream  byteArrayOutputStream = new ByteArrayOutputStream();
        try {

            String createText = kaptchaConfig.getDefaultKaptcha().createText();
            request.getSession().setAttribute("rightCode",createText);//将产生的验证码字符串保存到session中
            //将产生的验证码字符串返回到一个BuffereImage对象并转为byte，写入到byte的数组中
            BufferedImage bufferedImage = kaptchaConfig.getDefaultKaptcha().createImage(createText);
            ImageIO.write(bufferedImage,"jpg",byteArrayOutputStream);
        } catch (IOException e) {
            response.sendError(500);
            return;
        }
        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = byteArrayOutputStream.toByteArray();
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(captchaChallengeAsJpeg);
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ApiOperation(value = "用户登录的方法",notes = "需要传入用户名密码")

    public ResponseBean login(@RequestParam("username") String username,
                          @RequestParam("password") String password,HttpServletRequest request){
        SysUserEntity userEntity = userService.findByUserName(username);
        String pwd=JWTUtil.sha256(password);//对密码进行加密
        Subject subject = SecurityUtils.getSubject();
        String jwttoken = JWTUtil.sing(username,pwd);
        subject.login(new JWTToken(jwttoken));
        if (userEntity.getLoginpass().equals(pwd)){
            String IP = IpUtil.getIP(request);
            userEntity.setLastloginip(IP);
            int a=userService.updateIP(userEntity);
            return new ResponseBean(200,"登录成功", JWTUtil.sing(username,pwd)+"+"+a);
        }else {
            throw new UnauthorizedException();
        }
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
    public String addUser(){
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setLoginname("fyg");
        userEntity.setLoginpass("789");
        userEntity.setArea("wer");
        userEntity.setCity("er");
        userEntity.setCompanyid(45l);
        userEntity.setCreatetime(new Date());
        userEntity.setLastloginaddr("3254");
        userEntity.setEmail("sdfsdf");
        userEntity.setLastloginip("798");
        userEntity.setLastlogintime(new Date());
        userEntity.setLogincount(1l);
        userEntity.setProvince("234");
        userEntity.setRemark("werwe");
        userEntity.setRoleid(1l);
        userEntity.setRemark("wer");
        userEntity.setRealname("465");
        int a = userService.addUser(userEntity);
        if (a!=0){
            return "添加成功";
        }else {
            return "798";
        }
    }

    @RequestMapping("/getUserList")
    @RequiresAuthentication()
    @ApiOperation(value = "获得所有用户的信息",notes = "默认获得所有用户的新")
    public ResponseBean getUserList(){
        List<SysUserEntity> userEntities =userService.getUserList();
        return  new ResponseBean(200,"登录成功", userEntities);
    }

    @RequestMapping("/deleUser")
    @ApiOperation(value="删除",notes="用户删除操作")
    public int deleUser(@RequestParam("id") String id){
        long i=Long.parseLong(id);
        return userService.deleteUser(i);

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
