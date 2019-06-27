package com.sias.entity;

/**
 * 订单项表 是订单和鲜花的中间表 因为鲜花和订单属于多对多的关系
 * id：订单项的id，flowerId：鲜花的id，count：数量，orderId，订单的id
 */
public class OrderItem {
    private String id;
    private String flowerId;
    private Integer count;
    private String orderId;

    private Flower flower;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", flowerId='" + flowerId + '\'' +
                ", count=" + count +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public OrderItem(String id, String flowerId, Integer count, String orderId, Flower flower) {
        this.id = id;
        this.flowerId = flowerId;
        this.count = count;
        this.orderId = orderId;
        this.flower = flower;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderItem() {
    }
}
