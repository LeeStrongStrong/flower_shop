package com.sias.entity;

import java.util.Date;

/**
 * 订单实体类
 * id：订单编号，orderNo：订单号，total：总计，createDate：创建时间
 * addressId：地址的id，userId：用户的id
 */
public class Order {
    private String id;
    private String orderNo;
    private Double total;
    private Date createDate;
    private String addressId;
    private String userId;

    /**
     *关系属性
     */
    private Address address;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", total=" + total +
                ", createDate=" + createDate +
                ", addresId='" + addressId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order(String id, String orderNo, Double total, Date createDate, String addressId, String userId, Address address) {
        this.id = id;
        this.orderNo = orderNo;
        this.total = total;
        this.createDate = createDate;
        this.addressId = addressId;
        this.userId = userId;
        this.address = address;
    }

    public Order() {
    }
}
