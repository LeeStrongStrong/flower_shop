package com.sias.test;

import com.sias.dao.OrderDao;
import com.sias.entity.Address;
import com.sias.entity.Order;
import com.sias.entity.OrderItem;
import com.sias.util.MybatisUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 测试订单的dao方法
 */
public class TestOrder {
    /**
     * 测试添加订单
     */
    @Test
    public void testAddOrder(){
        OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
        Order order = new Order("000","000",12.0,new Date(),"001","001",new Address());
        orderDao.addOrder(order);
        MybatisUtil.commit();
    }
    /**
     * 查询所有订单的方法
     */
    @Test
    public void testSelectAllOrder(){
        OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
        List<Order> orders = orderDao.selectAllOrder();
        for (Order order : orders) {
            System.out.println(order);
        }
    }
    /**
     * 测试查询一个订单的方法
     */
    @Test
    public void testSelectOne(){
        OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
        Order order = orderDao.selectOrderById("000");
        System.out.println(order);
    }

    /**
     * 测试查询订单下的所有订单项
     */
    @Test
    public void testSelectAllOrderItem(){
        OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
        List<OrderItem> orderItems = orderDao.selectAllOrderItem("000");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

}
