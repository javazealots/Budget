package com.hogan.budget.dao;

import com.hogan.budget.bean.User;

/**
 * Created by Hogan on 9/5/2016.
 * 用户数据层接口
 */
public interface UserDao {

    /**
     * 根据最近一次登录时间查询用户信息
     *
     * @return
     */
    User findByLastLoginDate();
}
