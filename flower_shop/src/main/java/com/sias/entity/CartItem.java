package com.sias.entity;

/**
 * 购物车项实体类
 *
 */
public class CartItem {
    private Flower flower;
    private Integer count;

    @Override
    public String toString() {
        return "CartItem{" +
                "flower=" + flower +
                ", count=" + count +
                '}';
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartItem(Flower flower, Integer count) {
        this.flower = flower;
        this.count = count;
    }

    public CartItem() {
    }
}
