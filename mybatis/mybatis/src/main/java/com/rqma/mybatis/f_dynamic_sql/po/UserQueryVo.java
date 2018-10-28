package com.rqma.mybatis.f_dynamic_sql.po;

import java.util.List;

/**
 * @Description:
 * @Auther: RQMA
 * @Date: 2018/10/26 19:35
 */

public class UserQueryVo {
    //用户查询条件
    private UserCustom userCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    //传入多个id
    private List<Integer> ids;

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
