package com.zhoujixing.mapper;

import com.zhoujixing.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 添加用户的方法
     * @param userEntity
     * @return
     */
    int insertUser(SysUserEntity userEntity);

    /**
     * 获得用户的方法
     * @return
     */
    List<SysUserEntity> getUserList();

    /**
     * 根据条件获得对应的集合
     * @param userEntity
     * @return
     */
    List<SysUserEntity> findByUser(SysUserEntity userEntity);

    /**
     * 根据用户编号删除对应用户
     * @param id
     * @return
     */
    int deleteUser(long id);

    /**
     * 根据用户名称查询出对应用户信息
     * @param username
     * @return
     */
    SysUserEntity findByUserName(String username);

    /**
     * 更新用的IP地址
     * @param userEntity 用户编号
     * @return
     */
    int updateIP(SysUserEntity userEntity);

    /**
     * 用户分页的方法
     * @param data
     * @return
     */
    List<SysUserEntity> getPageUser(Map<String,Object> data);

    /**
     * 修改密码的方法
     * @param userEntity
     * @return
     */
    int updatepassword(SysUserEntity userEntity);

    /**
     * 返回总条数
     * @return
     */
    int usercount();

    /**
     * 用户更新的方法
     * @param userEntity
     * @return
     */
    int userUpdate(SysUserEntity userEntity);

    /**
     * 根据编号获得对象
     * @param id
     * @return
     */
    SysUserEntity getbyId(String id);
}
