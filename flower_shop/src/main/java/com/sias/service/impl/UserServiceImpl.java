package com.sias.service.impl;

import com.sias.dao.UserDao;
import com.sias.entity.User;
import com.sias.service.UserService;
import com.sias.util.MybatisUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    /**
     * 用户登录的方法
     * @param user
     */
    @Override
    public void login(User user) {
        //获取userDao
        UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
        //根据Email获取User对象
        User checkUser = userDao.selectUserByEmail(user.getEmail());
        MybatisUtil.close();
        // 比较验证码
        // 获取session中验证码
        if(checkUser!=null){
            //判断密码是否正确
            if(checkUser.getPassword().equals(user.getPassword())){
                //判断状态是否正常
                String stas="正常";
                if(stas.equals(checkUser.getStatus())){
                    //获取session
                    HttpSession session = ServletActionContext.getRequest().getSession();
                    session.setAttribute("loginUser", checkUser);
                }else{
                    throw new RuntimeException("账户被冻结");
                }
            }else{
                throw new RuntimeException("密码错误");
            }
        }else{
            throw new RuntimeException("用户名不存在");
        }
    }

    /**
     * 用户注册的方法
     * @param user
     */
    @Override
    public void regist(User user) {
        //获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        //1、判断该用户是否已经注册
        //获取userDao
        UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
        User checkUser = userDao.selectUserByEmail(user.getEmail());
        //未注册
        if(checkUser==null){
            user.setId(UUID.randomUUID().toString());
            user.setStatus("正常");
            try{
                userDao.regist(user);
                session.setAttribute("loginUser", user);
                MybatisUtil.commit();
            }catch(Exception e){
                e.printStackTrace();
                MybatisUtil.rollback();
                throw new RuntimeException("用户注册失败");
            }
        }else{
            throw new RuntimeException("邮箱已经存在");
        }
    }

    /**
     * 后台：查询所有用户信息
     * @return
     */
    @Override
    public List<User> selectAllUser() {
        try{
            UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
            return userDao.selectAllUser();
        }finally{
            MybatisUtil.close();
        }
    }

    /**
     * 后台：修改用户的状态
     * @param userId
     * @param status
     */
    @Override
    public void updateStatus(String userId, String status) {
        String nomal="正常";
        try{
            UserDao userDao = MybatisUtil.getSqlSession().getMapper(UserDao.class);
            if(nomal.equals(status)){
                status = "冻结";
                userDao.updateStatus(userId, status);
            }else{
                status = "正常";
                userDao.updateStatus(userId, status);
            }
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }
    }
}
