package com.zhoujixing.controller;

import com.zhoujixing.entity.SysRoleEntity;
import com.zhoujixing.service.SysRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private SysRoleService roleService;

    @RequestMapping("/addRole")
    @ApiOperation(value = "添加角色的方法")
    public String addRole(@RequestParam("name") String name, @RequestParam("discription") String discription,
                          @RequestParam("state") Integer state, @RequestParam("rootflag") Integer rootflag,
                          @RequestParam("creatorid") Long creatorid,
                          @RequestParam("options") String options,@RequestParam("fromsite") Long fromsite,
                          @RequestParam("platform") String platform){
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        sysRoleEntity.setName(name);
        sysRoleEntity.setDiscription(discription);
        sysRoleEntity.setState(state);
        sysRoleEntity.setRootflag(rootflag);
        sysRoleEntity.setCreatorid(creatorid);
        sysRoleEntity.setCreatetime(new Date());
        sysRoleEntity.setOptions(options);
        sysRoleEntity.setFromsite(fromsite);
        sysRoleEntity.setPlatform(platform);
        int a = roleService.addRole(sysRoleEntity);
        if (a>0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @RequestMapping("delRole")
    @ApiOperation(value = "角色删除的方法",notes = "传入需要删除的编号")
    public String  delRole(@RequestParam("id") String id){
        int a = roleService.delRole(id);
        if (a>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @RequestMapping("/getRoleList")
    @ApiOperation(value = "获得所有角色的方法")
    public List<SysRoleEntity> getRoleList(){
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        return roleService.getRoleList(sysRoleEntity);
    }

}
