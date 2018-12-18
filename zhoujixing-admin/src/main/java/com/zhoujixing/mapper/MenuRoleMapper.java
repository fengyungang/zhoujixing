package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysMenuRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuRoleMapper {
    /**
     * 添加角色和菜单关系
     * @return
     */
    int insertMenuRole(SysMenuRoleEntity sysMenuRoleEntity);

    /**
     * 删除角色和菜单的关系
     * @param id
     * @return
     */
    int deleteMenuRole(String id);

    /**
     * 修改角色和菜单的关系
     * @param sysMenuRoleEntity
     * @return
     */
    int updateMenuRole(SysMenuRoleEntity sysMenuRoleEntity);
}
