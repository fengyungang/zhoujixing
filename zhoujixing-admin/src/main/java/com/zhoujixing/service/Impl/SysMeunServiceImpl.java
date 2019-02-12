package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.mapper.MenuMapper;
import com.zhoujixing.service.SysMeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysMeunServiceImpl implements SysMeunService {

    @Autowired
    private MenuMapper sysMenuMapper;

    public int inserSysMenu(SysMenuEntity sysMenuEntity){
        return sysMenuMapper.inserSysMenu(sysMenuEntity);
    }

    @Override
    public List<SysMenuEntity> getMenuList(int rows,int page) {
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("currIndex",(page-1)*rows);
        data.put("pageSize",rows);
        return sysMenuMapper.getMenuList(data);
    }

    @Override
    public int delMenu(String id) {
        return sysMenuMapper.delMenu(id);
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long roleid) {

        if (roleid == 29){
            return getAllMenuList(null);
        }

        List<Long> menuIdList = sysMenuMapper.UserIdListMen(roleid);
        return getAllMenuList(menuIdList);
    }

    @Override
    public int menucount() {
        return sysMenuMapper.menucount();
    }

    @Override
    public SysMenuEntity byId(String id) {
        return sysMenuMapper.byId(Long.parseLong(id));
    }

    @Override
    public int updatemenu(SysMenuEntity sysMenuEntity) {
        return sysMenuMapper.updatemenu(sysMenuEntity);
    }

    /***
     * 获得所有菜单列表
     * @param menuIdList
     * @return
     */
    private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList) {
        //查询跟菜单列表
        List<SysMenuEntity> menuList = queryListParentId(0L,menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList,menuIdList);

        return menuList;
     }

    private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList) {
        List<SysMenuEntity> subMnuList = new ArrayList<SysMenuEntity>();

        for (SysMenuEntity entity : menuList){
            if (entity.getMenutype() == 2){
                entity.setList(getMenuTreeList(queryListParentId(entity.getId(),menuIdList),menuIdList));
            }
            subMnuList.add(entity);
        }
        return subMnuList;
    }

    private List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
        List<SysMenuEntity> menuList = getistParentId(parentId);
        if (menuIdList == null){
            return menuList;
        }
        List<SysMenuEntity> userMenuList = new ArrayList<>();
        for (SysMenuEntity menu : menuList){
            if (menuIdList.contains(menu.getId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    /**
     * 根据父类菜单，查询子菜单
     * @param parentId
     * @return
     */
    private List<SysMenuEntity> getistParentId(Long parentId) {
        return sysMenuMapper.getistParentId(parentId);
    }


}
