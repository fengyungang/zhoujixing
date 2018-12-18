package com.zhoujixing.service;


import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.entity.SysUserEntity;

import java.util.List;

public interface SysUserService {
    /**
     * 添加用户信息的方法
     * @param userEntity
     * @return
     */
    int addUser(SysUserEntity userEntity);

    /**
     * 获得所有用户信息的方法
     * @return
     */
    List<SysUserEntity> getUserList();

    /**
     * 根据用户编号进行相应的删除
     * @param id
     * @return
     */
    int deleteUser(long id);

    /**
     * 根据用户名获得对应的用户信息
     * @param username
     * @return
     */
    SysUserEntity findByUserName(String username);

    /**
     * 根据用户名获得对应的权限
     * @param username
     * @return
     */
    List<SysMenuEntity> findMenuByUserName(String username);

    /**
     * 更新用户IP地址
     * @param userEntity 用户编号
     */
    int updateIP(SysUserEntity userEntity);
}
