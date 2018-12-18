package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysMenuRoleEntity;
import com.zhoujixing.mapper.MenuMapper;
import com.zhoujixing.mapper.MenuRoleMapper;
import com.zhoujixing.service.SysMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuRoleServiceImpl implements SysMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public int addMenuRole(SysMenuRoleEntity sysMenuRoleEntity) {
        return menuRoleMapper.insertMenuRole(sysMenuRoleEntity);
    }

    @Override
    public int delMenuRole(String id) {
        return menuRoleMapper.deleteMenuRole(id);
    }
}
