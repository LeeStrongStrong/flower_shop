package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.Admin;
import com.sias.service.AdminService;
import com.sias.service.impl.AdminServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * 管理员页面交互有关的action方法
 */
public class AdminAction {
    /**
     * admin:登录的Admin对象
     * errorMessage:错误信息
     */
    private Admin admin;
    private String errorMessage;


    /**
     * 后台:管理员登录
     * @return
     */
    public String login(){
        AdminService adminService = new AdminServiceImpl();
        try{
            adminService.login(admin);
            return Action.SUCCESS;
        }catch(Exception e){
            errorMessage=e.getMessage();
            e.printStackTrace();
            return Action.ERROR;
        }
    }
    /**
     * 后台:安全退出
     * @return
     */
    public String safeOut(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.removeAttribute("loginAdmin");
        return Action.SUCCESS;
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
