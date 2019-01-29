package com.zhoujixing.service;

import com.zhoujixing.entity.User;

public interface UserService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    User getById(Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean modifyUser(User user);
}
