package com.sias.test;

import com.sias.dao.AdminDao;
import com.sias.entity.Admin;
import com.sias.util.MybatisUtil;
import org.junit.Test;

/**
 * 测试AdminDao
 */
public class TestAdmin {
    /**
     * 测试管理员登录
     */
    @Test
    public void testLogin(){
        AdminDao adminDao = MybatisUtil.getSqlSession().getMapper(AdminDao.class);
        Admin loginAdmin = new Admin(null,"admin","admin");
        Admin admin = adminDao.login(loginAdmin.getUsername());
        if(admin!=null){
            if(!admin.getPassword().equals(loginAdmin.getPassword())){
                System.out.println("密码错误");
            }else{
                System.out.println("登录成功");
                System.out.println(admin);
            }
        }else{
            System.out.println("用户名不存在");
        }
    }
}
