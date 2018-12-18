package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysRoleEntity;
import com.zhoujixing.mapper.RoleMapper;
import com.zhoujixing.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
