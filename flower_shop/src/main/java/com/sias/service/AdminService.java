package com.sias.service;

import com.sias.entity.Admin;

/**
 * 管理员有关的service层业务方法
 */
public interface AdminService {
    /**
     * 管理员登录的业务方法
     * @param admin 用户名
     * @return 返回一个根据用户名查询所得的管理员对象
     */
    Admin login(Admin admin);

}
