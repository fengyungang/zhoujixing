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
    List<SysMenuEntity> getMenuList(int rows,int page);

    /**
     * 删除菜单方法
     * @param id
     * @return
     */
    int delMenu(String id);

    /***
     * 根据用户编号获得所有菜单
     * @param userid
     * @return
     */
    List<SysMenuEntity> getUserMenuList(Long userid);

    /**
     * 返回菜单总条数
     * @return
     */
    int menucount();

    /**
     * 根据编号获得对应实体
     * @param id
     * @return
     */
    SysMenuEntity byId(String id);

    /**
     * 菜单更新的方法
     * @param sysMenuEntity
     * @return
     */
    int updatemenu(SysMenuEntity sysMenuEntity);
}
