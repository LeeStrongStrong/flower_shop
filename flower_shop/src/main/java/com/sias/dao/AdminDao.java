package com.sias.dao;

import com.sias.entity.Admin;

/**
 * 管理员dao方法
 */
public interface AdminDao {
    /**
     * 后台:管理员登录方法
     * @param username :用户名
     * @return 返回Admin对象
     */
    Admin login(String username);
}
