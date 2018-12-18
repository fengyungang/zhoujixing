package com.zhoujixing.controller;

import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.service.SysMenuRoleService;
import com.zhoujixing.service.SysMeunService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private SysMeunService sysMeunService;

    @RequestMapping("/addMenu")
    @ApiOperation(value = "添加菜单方法")
    public String addMenu(@RequestParam("parentid") String parentid,@RequestParam("menuname") String menuname,
                          @RequestParam("ordernum") Integer ordernum,@RequestParam("url") String url,
                          @RequestParam("icon") String icon,@RequestParam("attributes") String attributes,
                          @RequestParam("actions") String actions,@RequestParam("platform") String platform,
                          @RequestParam("creatorid") Long creatorid,@RequestParam("state") Integer state,
                          @RequestParam("menutype") Integer menutype){
        SysMenuEntity sysMenuEntity = new SysMenuEntity();
        sysMenuEntity.setParentid(parentid);
        sysMenuEntity.setMenuname(menuname);
        sysMenuEntity.setOrdernum(ordernum);
        sysMenuEntity.setUrl(url);
        sysMenuEntity.setIcon(icon);
        sysMenuEntity.setAttributes(attributes);
        sysMenuEntity.setActions(actions);
        sysMenuEntity.setPlatform(platform);
        sysMenuEntity.setCreatorid(creatorid);
        sysMenuEntity.setState(state);
        sysMenuEntity.setMenutype(menutype);
        int a = sysMeunService.inserSysMenu(sysMenuEntity);
        if (a>0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @RequestMapping("/getMenuList")
    @ApiOperation(value = "获得所有菜单的方法")
    public List<SysMenuEntity> getMenuList(){
        return sysMeunService.getMenuList();
    }

    @RequestMapping("/delMenu")
    @ApiOperation(value = "删除菜单的方法")
    public String delMenu(@RequestParam("id") String id){
        int a = sysMeunService.delMenu(id);
        if (a>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

}
