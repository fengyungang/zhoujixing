package com.zhoujixing.controller;

import com.zhoujixing.entity.SysMenuRoleEntity;
import com.zhoujixing.service.SysMenuRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuRoleController {

    @Autowired
    private SysMenuRoleService sysMenuRoleService;

    @RequestMapping("/addMenuRole")
    @ApiOperation(value = "权限分配")
    public String addMenuRole(@RequestParam("roleid") Long roleid,@RequestParam("menuid") Long menuid){
        SysMenuRoleEntity sysMenuRoleEntity = new  SysMenuRoleEntity();
        sysMenuRoleEntity.setRoleid(roleid);
        sysMenuRoleEntity.setMenuid(menuid);
        int a = sysMenuRoleService.addMenuRole(sysMenuRoleEntity);
        if (a>0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @RequestMapping("/delMenuRole")
    @ApiOperation(value = "删除权限的方法")
    public String delMenuRole(@RequestParam("id") String id){
        int a = sysMenuRoleService.delMenuRole(id);
        if (a>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

}
