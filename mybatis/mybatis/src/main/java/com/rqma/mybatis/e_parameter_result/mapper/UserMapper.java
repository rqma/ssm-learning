package com.rqma.mybatis.e_parameter_result.mapper;


import com.rqma.mybatis.e_parameter_result.po.User;
import com.rqma.mybatis.e_parameter_result.po.UserCustom;
import com.rqma.mybatis.e_parameter_result.po.UserQueryVo;

import java.util.List;

/**
 * @Description:
 * @Auther: RQMA
 * @Date: 2018/10/25 17:01
 */

public interface UserMapper {
    //用户信息综合查询
    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
    //用户信息综合查询总数
    public int findUserCount(UserQueryVo userQueryVo) throws Exception;
    public User findUserByIdResultMap(int id)throws Exception;
}
