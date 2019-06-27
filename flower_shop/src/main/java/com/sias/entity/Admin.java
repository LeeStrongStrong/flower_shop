package com.sias.entity;

/**
 * 管理员实体类
 * id：管理员编号
 * username：管理员的用户名
 * password：管理员的密码
 */
public class Admin {
    private String id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Admin() {
    }
}
