package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.mapper.MenuMapper;
import com.zhoujixing.service.SysMeunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMeunServiceImpl implements SysMeunService {

    @Autowired
    private MenuMapper sysMenuMapper;

    public int inserSysMenu(SysMenuEntity sysMenuEntity){
        return sysMenuMapper.inserSysMenu(sysMenuEntity);
    }

    @Override
    public List<SysMenuEntity> getMenuList() {
        return sysMenuMapper.getMenuList();
    }

    @Override
    public int delMenu(String id) {
        return sysMenuMapper.delMenu(id);
    }


}
