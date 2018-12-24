package com.zhoujixing.service.Impl;

import com.zhoujixing.entity.SysMenuEntity;
import com.zhoujixing.mapper.MenuMapper;
import com.zhoujixing.service.SysUserService;
import com.zhoujixing.entity.SysUserEntity;
import com.zhoujixing.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper sysMenuMapper;


    public int addUser(SysUserEntity userEntity) {
        return userMapper.insertUser(userEntity);
    }


    public List<SysUserEntity> getUserList() {
        return userMapper.getUserList();
    }


    public int deleteUser(long id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public SysUserEntity findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<SysMenuEntity> findMenuByUserName(String username) {
        SysUserEntity sysUserEntity = userMapper.findByUserName(username);

        List<SysMenuEntity> list = sysMenuMapper.byUserIdListMen(sysUserEntity.getRoleid());
        return list;
    }

    @Override
    public int updateIP(SysUserEntity userEntity) {
        int a = userMapper.updateIP(userEntity);
        return a;
    }

    @Override
    public List<SysUserEntity> getPageUser(int page, int rows) {
        Map<String,Object> data = new HashMap<String, Object>();
        data.put("currIndex",(page-1)*rows);
        data.put("pageSize",rows);
        List<SysUserEntity> list =userMapper.getPageUser(data);
        return list;
    }
}
