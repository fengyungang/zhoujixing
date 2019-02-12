package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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
    SysMenuEntity byId(long id);

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
    List<Long> UserIdListMen(long userid);

    List<SysMenuEntity> byUserIdListMen(long userid);
    /**
     * 获得所有菜单分页的方法
     * @return
     */
    List<SysMenuEntity> getMenuList(Map<String,Object> data);

    /**
     * 删除菜单的方法
     * @param id
     * @return
     */
    int delMenu(String id);

    /**
     * 根据父类菜单，查询子菜单
     * @param parentId
     * @return
     */
    List<SysMenuEntity> getistParentId(Long parentId);

    /**
     * 获得菜单的总条数
     * @return
     */
    int menucount();

    /**
     * 菜单更新的方法
     * @param sysMenuEntity
     * @return
     */
    int updatemenu(SysMenuEntity sysMenuEntity);
}
