package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.Address;
import com.sias.entity.Admin;
import com.sias.entity.Order;
import com.sias.entity.OrderItem;
import com.sias.service.OrderService;
import com.sias.service.impl.OrderServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 订单相关的action方法
 */
public class OrderAction {
    private Address address;
    private String message;
    private List<Order> list;
    private Order order;
    private List<OrderItem> orderItems;
    private String id;

    private OrderService orderService = new OrderServiceImpl();
    /**
     * 前台:添加订单
     * @return
     */
    public String addOrder(){
        try{
            orderService.addOrder(address);
        }catch(Exception e){
            message = e.getMessage();
        }
        return Action.SUCCESS;
    }

    /**
     * 查询所有订单
     * @return
     */
    public String selectAllOrder(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        if(loginAdmin==null){
            return Action.ERROR;
        }else{
            list = orderService.selectAllOrder();
            return Action.SUCCESS;
        }
    }

    /**
     * 根据id查询订单
     * @return
     */
    public String selectOrderById(){
        //查询订单的对象
        order = orderService.selectOrderById(id);
        //查询该订单下的所有订单项
        orderItems = orderService.selectAllOrderItem(id);
        return Action.SUCCESS;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
        this.list = list;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
