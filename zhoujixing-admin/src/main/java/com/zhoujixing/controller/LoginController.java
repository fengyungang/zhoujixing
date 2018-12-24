package com.zhoujixing.controller;

import com.zhoujixing.config.KaptchaConfig;
import com.zhoujixing.entity.SysUserEntity;
import com.zhoujixing.service.SysUserService;
import com.zhoujixing.shiro.JWTToken;
import com.zhoujixing.shiro.JWTUtil;
import com.zhoujixing.shiro.ResponseBean;
import com.zhoujixing.shiro.UnauthorizedException;
import com.zhoujixing.utils.IpUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private KaptchaConfig kaptchaConfig;

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
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

    @RequestMapping("/denglu")
    public String denglu(){
        return "login";
    }

    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public ResponseBean login(@RequestParam("username") String username,
                              @RequestParam("yanzhengma") String yanzhengma,
                              @RequestParam("password") String password, HttpServletRequest request){
        SysUserEntity userEntity = userService.findByUserName(username);
        String pwd= JWTUtil.sha256(password);//对密码进行加密
        Subject subject = SecurityUtils.getSubject();
        String jwttoken = JWTUtil.sing(username,pwd);
        subject.login(new JWTToken(jwttoken));
        String str= (String) request.getSession().getAttribute("rightCode");
        if (yanzhengma.equals(str)){
            return new ResponseBean(500,"验证码错误",null);
        }
        if (userEntity==null){
            return new ResponseBean(500,"用户名错误",null);
        }
        if (userEntity.getLoginpass().equals(pwd)){
            String IP = IpUtil.getIP(request);
            userEntity.setLastloginip(IP);
            int a=userService.updateIP(userEntity);
            return new ResponseBean(200,"登录成功", JWTUtil.sing(username,pwd)+"+"+a);
        }else {
            throw new UnauthorizedException();
        }
    }
}
