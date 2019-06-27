package com.sias.entity;

/**
 * 用户实体类
 * id：用户编号，email：用户邮箱，password：用户密码
 * nickName：昵称，status：状态(冻结或者正常)
 */
public class User {
    private String id;
    private String email;
    private String password;
    private String nickName;
    private String status;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String id, String email, String password, String nickName, String status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.status = status;
    }

    public User() {
    }
}
