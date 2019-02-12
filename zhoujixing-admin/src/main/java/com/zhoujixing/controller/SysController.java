package com.zhoujixing.controller;

import com.zhoujixing.entity.SysCityEntity;
import com.zhoujixing.entity.SysRoleEntity;
import com.zhoujixing.entity.SysUserEntity;
import com.zhoujixing.service.SysCityService;
import com.zhoujixing.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SysController {
    @Autowired
    private SysCityService sysCityService;

    @Autowired
    private SysRoleService roleService;

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
    public String index(HttpServletRequest request){
        SysUserEntity user = (SysUserEntity) request.getSession().getAttribute("user");
        if (user!=null){
            return "index";
        }else {
            return "denglu";
        }
    }
    @RequestMapping("/getRoleGrid")
    public String getRoleGrid(){
        return "admin/sysrole";
    }

    /**
     * 获取用户信息页面的方法
     * @return
     */
    @RequestMapping("/sysuser")
    public ModelAndView sysuser(){
        ModelAndView mod = new ModelAndView();
        List<SysCityEntity> list = sysCityService.getAllCityList();
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        List<SysRoleEntity> roleList = roleService.getRoleList(sysRoleEntity);
        mod.setViewName("admin/sysuser");
        mod.addObject("citylist",list);
        mod.addObject("roleList",roleList);
        return mod;
    }

    @RequestMapping("/zhuyao")
    public String zhuyao(){
        return "main";
    }

    @RequestMapping("/aadd")
    public String aadd(){
        return "add";
    }

    @RequestMapping("/getmenulist")
    public String getmenulist(){
        return "admin/sysmenu";
    }
}
