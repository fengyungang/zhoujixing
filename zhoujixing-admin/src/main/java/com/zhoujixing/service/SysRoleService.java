package com.zhoujixing.service;

import com.zhoujixing.entity.SysRoleEntity;

import java.util.List;

public interface SysRoleService {
    int addRole(SysRoleEntity sysRoleEntity);

    int delRole(String id);

    List<SysRoleEntity> getRoleList(SysRoleEntity sysRoleEntity);

    /**
     * 分页的方法
     * @param page
     * @param rows
     * @return
     */
    List<SysRoleEntity> getPageList(int page, int rows);

    /**
     * 获得角色的总条数
     * @return
     */
    int rolecount();

    /**
     * 根据编号获得对应对象
     * @param id
     * @return
     */
    SysRoleEntity getbyid(String id);

    /**
     * 角色更新的方法
     * @param sysRoleEntity
     * @return
     */
    int roleupdate(SysRoleEntity sysRoleEntity);
}
