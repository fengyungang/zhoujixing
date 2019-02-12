package com.zhoujixing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhoujixing.entity.SysRoleEntity;
import com.zhoujixing.service.SysRoleService;
import com.zhoujixing.shiro.ResponseBean;
import com.zhoujixing.utils.PageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private SysRoleService roleService;

    @RequestMapping("/addRole")
    @ApiOperation(value = "添加角色的方法")
    public ResponseBean addRole(@RequestParam String strjson){
        ObjectMapper mapper = new ObjectMapper();
        SysRoleEntity sysRoleEntity = null;
        try {
            sysRoleEntity = mapper.readValue(strjson, SysRoleEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = roleService.addRole(sysRoleEntity);
        if (a>0){
            return new ResponseBean(200,"添加成功",null);
        }else {
            return new ResponseBean(200,"添加失败",null);
        }
    }

    @RequestMapping("/delRole")
    @ApiOperation(value = "角色删除的方法",notes = "传入需要删除的编号")
    public ResponseBean  delRole(@RequestParam("id") String id){
        int a = roleService.delRole(id);
        if (a>0){
            return new ResponseBean(200,"删除成功",null);
        }else {
            return new ResponseBean(500,"删除失败",null);
        }
    }

    @RequestMapping("/getRoleList")
    @ApiOperation(value = "获得所有角色的方法")

    public List<SysRoleEntity> getRoleList(){
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        return roleService.getRoleList(sysRoleEntity);
    }

    /**
     * 角色分页的的方法
     * @param params
     * @return
     */
    @RequestMapping("/getRoleGridList")
    @ResponseBody
    public PageUtils getRoleGridList(@RequestParam Map<String,Object> params){
        String page = (String) params.get("page");
        String rows = (String) params.get("limit");
        List<SysRoleEntity> list = roleService.getPageList(Integer.parseInt(page),Integer.parseInt(rows));
        int count = roleService.rolecount();
        PageUtils pageUtils =new PageUtils(list,count,Integer.parseInt(rows),Integer.parseInt(page));
        return pageUtils;
    }

    /**
     * 根据编号获得对应对象
     * @param id
     * @return
     */
    @RequestMapping("/getbyid")
    @ResponseBody
    public SysRoleEntity getbydi(@RequestParam String id){
        return roleService.getbyid(id);
    }

    /**
     * 角色更新的方法
     * @param strjson
     * @return
     */
    @RequestMapping("/updaterole")
    @ResponseBody
    public ResponseBean updaterole(@RequestParam String strjson){
        ObjectMapper mapper = new ObjectMapper();
        SysRoleEntity sysRoleEntity = null;
        try {
            sysRoleEntity = mapper.readValue(strjson,SysRoleEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int a = roleService.roleupdate(sysRoleEntity);
        if(a>0){
            return new ResponseBean(200,"更新成功",null);
        }else {
            return new ResponseBean(200,"更新失败",null);
        }
    }
}
