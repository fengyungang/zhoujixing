package com.zhoujixing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.entity.SysUserEntity;
import com.zhoujixing.service.SysMenuRoleService;
import com.zhoujixing.service.SysMeunService;
import com.zhoujixing.shiro.ResponseBean;
import com.zhoujixing.utils.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @Autowired
    private SysMeunService sysMeunService;

    @RequestMapping("/addMenu")
    @ApiOperation(value = "添加菜单方法")
    @ResponseBody
    public ResponseBean addMenu(@RequestParam String strJsong){
        ObjectMapper mapper = new ObjectMapper();
        SysMenuEntity sysMenuEntity = null;
        try {
            sysMenuEntity = mapper.readValue(strJsong,SysMenuEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = sysMeunService.inserSysMenu(sysMenuEntity);
        if (a>0){
            return new ResponseBean(200,"添加成功",null);
        }else {
            return new ResponseBean(500,"添加失败",null);
        }
    }

    @RequestMapping("/getMenuList")
    @ResponseBody
    public PageUtils getMenuList(@RequestParam Map<String,Object> params){
        String page = (String) params.get("page");
        String rows = (String) params.get("limit");
        List<SysMenuEntity> list = sysMeunService.getMenuList(Integer.parseInt(rows),Integer.parseInt(page));
        int count = sysMeunService.menucount();
        PageUtils pageUtils =new PageUtils(list,count,Integer.parseInt(rows),Integer.parseInt(page));
        return pageUtils;
    }

    @RequestMapping("/getmenubyid")
    @ResponseBody
    public SysMenuEntity getbyid(@RequestParam String id){
        return sysMeunService.byId(id);
    }

    @RequestMapping("/geUserMenuList")
    @ResponseBody
    public List<SysMenuEntity> getUserMenuList(HttpServletRequest request){
        SysUserEntity sysUserEntity= (SysUserEntity) request.getSession().getAttribute("user");
        List<SysMenuEntity> list = sysMeunService.getUserMenuList(sysUserEntity.getRoleid());
        return list;
    }

    @RequestMapping("/delMenu")
    @ApiOperation(value = "删除菜单的方法")
    @ResponseBody
    public ResponseBean delMenu(@RequestParam String id){
        int a = sysMeunService.delMenu(id);
        if (a>0){
            return new ResponseBean(200,"删除成功",null);
        }else {
            return new ResponseBean(500,"删除失败",null);
        }
    }

    @RequestMapping("/updatemenu")
    @ResponseBody
    public ResponseBean updatemenu(@RequestParam String strJsong){
        SysMenuEntity sysMenuEntity= null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            sysMenuEntity = mapper.readValue(strJsong,SysMenuEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = sysMeunService.updatemenu(sysMenuEntity);
        if(a>0){
            return new ResponseBean(200,"更新成功",null);
        }else {
            return new ResponseBean(500,"更新失败",null);
        }

    }
}
