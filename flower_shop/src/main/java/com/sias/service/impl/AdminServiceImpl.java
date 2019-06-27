package com.sias.service.impl;

import com.sias.dao.AdminDao;
import com.sias.entity.Admin;
import com.sias.service.AdminService;
import com.sias.util.MybatisUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * 管理员有关的业务层方法实现
 */
public class AdminServiceImpl implements AdminService {
    /**
     * 用户登录的业务方法
     * @param admin 接收管理员登录的对象信息
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        AdminDao adminDao = MybatisUtil.getSqlSession().getMapper(AdminDao.class);
        Admin checkAdmin = adminDao.login(admin.getUsername());
        //判断管理员的用户名是否存在
        if(admin!=null){
            //判断密码是否正确
            if(!checkAdmin.getPassword().equals(admin.getPassword())){
                throw new RuntimeException("密码错误");
            }else{
                HttpSession session = ServletActionContext.getRequest().getSession();
                session.setAttribute("loginAdmin", checkAdmin);
                return checkAdmin;
            }
        }else{
            throw new RuntimeException("账号不存在！！");
        }
    }
}
