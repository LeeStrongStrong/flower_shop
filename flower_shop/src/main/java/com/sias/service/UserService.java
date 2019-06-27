package com.sias.service;

import com.sias.entity.User;

import java.util.List;

/**
 * 用户的service业务层方法
 */
public interface UserService {
    /**
     * 前台:用户登录方法
     * @param user
     */
    void login(User user);

    /**
     * 前台:用户注册功能
     * @param user
     */
    void regist(User user);

    /**
     * 后台:查询所有的用户信息
     * @return
     */
    List<User> selectAllUser();

    /**
     * 后台:修改用户状态
     */
    void updateStatus(String userId,String status);
}
