package com.zhoujixing.service.impl;

import com.zhoujixing.entity.User;
import com.zhoujixing.mapper.UserMapper;
import com.zhoujixing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean modifyUser(User user) {
        boolean result = false;
        if (userMapper.updateUser(user)>0){
            result = true;
        }
        return result;
    }
}
