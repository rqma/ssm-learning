package com.rqma.mybatis.c_mapper.mapper;

import com.rqma.mybatis.c_mapper.po.User;

import java.util.List;

/**
 * @Description:
 * @Auther: RQMA
 * @Date: 2018/10/25 17:01
 */

public interface UserMapper {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //根据用户名列查询用户列表
    public List<User> findUserByName(String name) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;

    //更新用户
    public void updateUser(User user) throws Exception;
}
