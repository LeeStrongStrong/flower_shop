package com.sias.test;

import com.sias.dao.UserDao;
import com.sias.entity.User;
import com.sias.util.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * 测试用户dao的方法
 */
public class TestUser {
    /**
     * 测试用户登录
     */
    @Test
    public void testLogin(){
        UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
        User loginUser = new User(null, "sias@qq.com", "123456", null, null);
        User user = userDao.selectUserByEmail(loginUser.getEmail());
        if(user!=null){
            if(user.getPassword().equals(loginUser.getPassword())){
                System.out.println("登陆成功");
            }else {
                System.out.println("密码错误");
            }
        }else {
            System.out.println("账户不存在");
        }
    }

    /**
     * 测试注册
     */
    @Test
    public void testRegist(){
        UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
        User user = new User("000", "000", "000000", "nameSSSS", "正常");
        userDao.regist(user);
        MybatisUtil.commit();
    }

    /**
     * 测试查询所有用户信息
     */
    @Test
    public void testSelectAllUser(){
        UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
        List<User> users = userDao.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试修改状态
     */
    @Test
    public void testUpdateStatus(){
        UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
        userDao.updateStatus("001","正常");
        MybatisUtil.commit();
    }
}
