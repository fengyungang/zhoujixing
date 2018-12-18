package com.zhoujixing.service;

import com.zhoujixing.entity.SysMenuRoleEntity;

public interface SysMenuRoleService {
    /**
     * 分配权限的方法
     * @param sysMenuRoleEntity
     * @return
     */
    int addMenuRole(SysMenuRoleEntity sysMenuRoleEntity);

    /**
     * 删除权限的方法
     * @param id
     * @return
     */
    int delMenuRole(String id);
}
