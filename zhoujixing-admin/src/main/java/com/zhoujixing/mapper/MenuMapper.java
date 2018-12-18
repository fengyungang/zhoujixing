package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    /**
     * 添加菜单的方法
     * @param entity
     * @return
     */
    int inserSysMenu(SysMenuEntity entity);

    /**
     * 根据编号获得对应的实体类
     * @param id
     * @return
     */
    SysMenuEntity byId(int id);

    /**
     * 保存并更新 (数据库里没有的插入，数据库里有的更新)
     * @param sysMenuEntity
     * @return
     */
    int insertOrUpdateCameraInfoByOne(SysMenuEntity sysMenuEntity);

    /**
     * 获得用户下面的所有菜单
     * @param userid
     * @return
     */
    List<SysMenuEntity> byUserIdListMen(long userid);

    /**
     * 获得所有菜单的方法
     * @return
     */
    List<SysMenuEntity> getMenuList();

    /**
     * 删除菜单的方法
     * @param id
     * @return
     */
    int delMenu(String id);
}
