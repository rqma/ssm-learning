package com.rqma.mybatis.e_parameter_result.po;

/**
 * @Description:
 * @Auther: RQMA
 * @Date: 2018/10/26 19:35
 */
public class UserQueryVo {
    //用户查询条件
    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }
    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
