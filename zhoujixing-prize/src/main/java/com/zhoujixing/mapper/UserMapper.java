package com.zhoujixing.mapper;


import com.zhoujixing.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

}
