package com.zhoujixing.service;

import com.zhoujixing.entity.SysMenuEntity;

import java.util.List;

public interface SysMeunService {

    /**
     * 添加菜单方法
     * @param sysMenuEntity
     * @return
     */
    int inserSysMenu(SysMenuEntity sysMenuEntity);

    /**
     * 获得所有菜单的方法
     * @return
     */
    List<SysMenuEntity> getMenuList();

    /**
     * 删除菜单方法
     * @param id
     * @return
     */
    int delMenu(String id);
}
