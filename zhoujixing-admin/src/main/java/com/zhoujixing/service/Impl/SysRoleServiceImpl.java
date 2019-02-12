package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysRoleEntity;
import com.zhoujixing.mapper.RoleMapper;
import com.zhoujixing.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(SysRoleEntity sysRoleEntity) {
        return roleMapper.inserSysRole(sysRoleEntity);
    }

    @Override
    public int delRole(String id) {
        return roleMapper.delete(id);
    }

    @Override
    public List<SysRoleEntity> getRoleList(SysRoleEntity sysRoleEntity) {
        return roleMapper.getList(sysRoleEntity);
    }

    @Override
    public List<SysRoleEntity> getPageList(int page, int rows) {
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("currIndex",(page-1)*rows);
        data.put("pageSize",rows);
        return roleMapper.getPageList(data);
    }

    @Override
    public int rolecount() {
        return roleMapper.rolecount();
    }

    @Override
    public SysRoleEntity getbyid(String id) {
        return roleMapper.getbyid(id);
    }

    @Override
    public int roleupdate(SysRoleEntity sysRoleEntity) {
        return roleMapper.roleupdate(sysRoleEntity);
    }
}
