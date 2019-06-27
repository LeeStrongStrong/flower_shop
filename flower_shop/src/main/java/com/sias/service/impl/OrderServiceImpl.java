package com.sias.service.impl;

import com.sias.dao.AddressDao;
import com.sias.dao.FlowerDao;
import com.sias.dao.ItermDao;
import com.sias.dao.OrderDao;
import com.sias.entity.*;
import com.sias.service.OrderService;
import com.sias.util.MybatisUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 订单service方法的实现
 */
public class OrderServiceImpl implements OrderService {
    /**
     *前台：添加新订单
     * @param address
     */
    @Override
    public void addOrder(Address address) {
        //获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        //作用域中取值
        //用户信息
        User loginUser = (User) session.getAttribute("loginUser");
        //总计
        Double total = (Double) session.getAttribute("total");
        //购物车信息
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        //获取dao
        AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
        OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
        ItermDao itemDao = MybatisUtil.getSqlSession().getMapper(ItermDao.class);
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);

        try{//1、判断是否是新的地址
            if(address.getId()==null || "".equals(address.getId())){
                //如果是新地址 新地址入库
                address.setId(UUID.randomUUID().toString());
                address.setUserId(loginUser.getId());
                addressDao.addAddress(address);
            }else{
                //如果是旧地址的话    判断是否更改了
                Address checkAddress = addressDao.selectAddressByAddressId(address.getId());
                if(!(checkAddress.equals(address))){
                    address.setUserId(loginUser.getId());
                    //不一样的话更新旧的地址
                    addressDao.updateAddress(address);
                }
            }
            //2、添加订单
            Order order = new Order();
            order.setId(UUID.randomUUID().toString());
            Date date = new Date();
            order.setOrderNo(String.valueOf(date.getTime()));
            session.setAttribute("orderNo", order.getOrderNo());
            order.setUserId(loginUser.getId());
            order.setTotal(total);
            order.setCreateDate(date);
            order.setAddressId(address.getId());
            orderDao.addOrder(order);
            //3.添加订单项
            for(Map.Entry<String,CartItem> entry : cart.entrySet()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(UUID.randomUUID().toString());
                orderItem.setFlowerId(entry.getKey());
                orderItem.setCount(entry.getValue().getCount());
                orderItem.setOrderId(order.getId());
                itemDao.addItem(orderItem);
                //4、更新销量
                flowerDao.updateFlowerSale(entry.getKey(),entry.getValue().getCount());
            }
            //5、移除购物车
            session.removeAttribute("cart");
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
            throw new RuntimeException("添加订单失败");
        }
    }
    /**
     * 后台:查询所有订单信息
     */
    @Override
    public List<Order> selectAllOrder() {
        try{
            OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
            return orderDao.selectAllOrder();
        }finally{
            MybatisUtil.close();
        }
    }

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    @Override
    public Order selectOrderById(String id) {
        try{
            OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
            return orderDao.selectOrderById(id);
        }finally{
            MybatisUtil.close();
        }
    }
    /**
     *后台:根据orderId查询所有的订单项
     */
    @Override
    public List<OrderItem> selectAllOrderItem(String orderId) {
        try{
            OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
            return orderDao.selectAllOrderItem(orderId);
        }finally{
            MybatisUtil.close();
        }
    }
}
