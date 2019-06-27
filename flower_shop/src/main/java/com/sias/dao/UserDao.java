package com.sias.dao;

import com.sias.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户有关的dao方法
 */
public interface UserDao {
    /**
     * 前台:用户登录方法
     * @param email 用户邮箱
     * @return 返回 User对象
     */
    User selectUserByEmail(@Param("email") String email);
    /**
     * 前台:用户注册的方法
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
    void updateStatus(@Param("userId")String userId,@Param("status")String status);
}
