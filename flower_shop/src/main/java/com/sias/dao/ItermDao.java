package com.sias.dao;

import com.sias.entity.OrderItem;

public interface ItermDao {
    /**
     * 添加订单项
     * @param orderItem
     */
    void addItem(OrderItem orderItem);
}
