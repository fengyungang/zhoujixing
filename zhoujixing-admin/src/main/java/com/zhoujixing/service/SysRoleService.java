package com.zhoujixing.service;

import com.zhoujixing.entity.SysRoleEntity;

import java.util.List;

public interface SysRoleService {
    int addRole(SysRoleEntity sysRoleEntity);

    int delRole(String id);

    List<SysRoleEntity> getRoleList(SysRoleEntity sysRoleEntity);
}
