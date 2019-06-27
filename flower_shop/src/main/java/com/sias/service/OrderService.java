package com.sias.service;

import com.sias.entity.Address;
import com.sias.entity.Order;
import com.sias.entity.OrderItem;

import java.util.List;

/**
 * 订单的service方法
 */
public interface OrderService {
    /**
     * 添加订单
     */
    void addOrder(Address address);

    /**
     * 后台:查询所有订单
     */
    List<Order> selectAllOrder();

    /**
     * 后台:根据id查询订单信息
     */

    Order selectOrderById(String id);

    /**
     * 后台:查询所有的订单项
     */
    List<OrderItem> selectAllOrderItem(String orderId);
}
