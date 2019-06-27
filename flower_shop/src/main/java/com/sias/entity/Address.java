package com.sias.entity;

/**
 * 地址实体类
 * id：地址编号，name：收件人姓名，phone：收件人手机号
 * local：详细地址，code：邮编号码，userId：用户的id
 */
public class Address {
    private String id;
    private String name;
    private String phone;
    private String local;
    private String code;
    private String userId;

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", local='" + local + '\'' +
                ", code='" + code + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Address(String id, String name, String phone, String local, String code, String userId) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.local = local;
        this.code = code;
        this.userId = userId;
    }

    public Address() {
    }
}
