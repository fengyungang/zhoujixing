package com.zhoujixing.service;


import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.entity.SysUserEntity;
import com.zhoujixing.utils.PageUtils;

import java.util.List;
import java.util.Map;

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

    /**
     * 获得用户分页的方法
     * @param page
     * @param rows
     * @return
     */
    List<SysUserEntity> getPageUser(int page,int rows);

    /**
     * 根据传入的条件获得对应的队形
     * @param sysUserEntity
     * @return
     */
    SysUserEntity findByUser(SysUserEntity sysUserEntity);

    /**
     * 用户修改密码的方法
     * @param user
     * @return
     */
    int updatepassword(SysUserEntity user);

    /**
     * 获得用户的总条数
     * @return
     */
    int count();

    /**
     * 用户更新的方法
     * @param userEntity
     * @return
     */
    int userUpdate(SysUserEntity userEntity);
}
