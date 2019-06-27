package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.Admin;
import com.sias.entity.User;
import com.sias.service.UserService;
import com.sias.service.impl.UserServiceImpl;
import com.sias.util.VerifyCodeUtils;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * 用户页面有关的action方法
 */
public class UserAction {
    /**
     * user:接受用户输入的用户信息
     * message:返回错误的信息
     * inputCode:用户输入的验证码
     */
    private User user;
    private String errorMessage;
    private String inputCode;
    /**
     * users：返回查询的所有用户信息
     * userId：接收用户id
     * status：接收用户的状态
     */
    private List<User> users;
    private String userId;
    private String status;

    private UserService userService = new UserServiceImpl();

    /**
     * 前台:用户登录的Action
     * @return
     */
    public String login(){
        try{
            userService.login(user);
            return Action.SUCCESS;
        }catch(Exception e){
            errorMessage =e.getMessage();
            return Action.ERROR;
        }
    }

    /**
     * 前台:用户注册的Action
     */
    public String regist(){
        try{
            System.out.println(inputCode);
            // 获取session中验证码
            String sessionCode = (String) ServletActionContext.getRequest()
                    .getSession().getAttribute("code1");
            System.out.println(sessionCode);
            if(sessionCode.equalsIgnoreCase(inputCode)){
                userService.regist(user);
                return Action.SUCCESS;
            }else{
                errorMessage = "验证码错误";
                return Action.ERROR;
            }
        }catch(Exception e){
            e.printStackTrace();
            errorMessage = e.getMessage();
            return Action.ERROR;
        }
    }
    /**
     * 后台:验证码方法
     * @throws IOException
     */
    public void getImage() throws IOException {
        // 1.生成字符
        String code1 = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println("验证码:"+code1);
        // 2.放入session
        ServletActionContext.getRequest().getSession()
                .setAttribute("code1", code1);
        // 3.生成图片
        BufferedImage image = VerifyCodeUtils.getImage(90, 40, code1);
        // 4.响应图片 获取响应流
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("image/png;charset=UTF-8");
        ServletOutputStream os = response.getOutputStream();
        // 5.输出图片
        ImageIO.write(image, "png", os);
        os.close();
    }
    /**
     * 前台:用户退出
     * @return
     */
    public String exit(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.removeAttribute("loginUser");
        return Action.SUCCESS;
    }
    /******************************************************************************/
    /**
     * 后台:查询所有的用户信息
     * @return
     */
    public String selectAllUser(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        if(loginAdmin==null){
            return Action.ERROR;
        }else{
            users = userService.selectAllUser();
            return Action.SUCCESS;
        }
    }

    /**
     * 后台:更新用户的状态
     * @return
     */
    public String updateStatus(){
        userService.updateStatus(userId, status);
        return Action.SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
