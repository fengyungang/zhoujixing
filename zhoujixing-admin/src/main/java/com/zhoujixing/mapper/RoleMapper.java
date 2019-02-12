package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    /**
     * 添加角色的方法
     * @param roleEntity
     * @return
     */
    int inserSysRole(SysRoleEntity roleEntity);

    /**
     * 根据编号获得对应的实体类
     * @param id
     * @return
     */
    SysRoleEntity byId(int id);

    /**
     * 删除角色的方法（物理删除）
     * @param id
     */
    int delete(String id);

    /**
     * 根据角色名称查询，如果名称为空返回所有角色
     * @param sysRoleEntity
     * @return
     */
    List<SysRoleEntity> getList(SysRoleEntity sysRoleEntity);

    /**
     * 角色分页的方法
     * @param data
     * @return
     */
    List<SysRoleEntity> getPageList(Map<String,Object> data);

    /**
     * 返回总条数
     * @return
     */
    int rolecount();

    /**
     * 根据编号获取编号
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
