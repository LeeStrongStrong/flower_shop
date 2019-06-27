package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.CartItem;
import com.sias.entity.Flower;
import com.sias.service.FlowerService;
import com.sias.service.impl.FlowerServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class CartAction {
    private FlowerService flowerService = new FlowerServiceImpl();

    private String flowerId;
    private Integer num;
    /**
     * 前台:添加购物车
     * @return
     */
    public String addCart() {
        // 获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        @SuppressWarnings("unchecked")
        Map<String, CartItem> cart = (Map<String, CartItem>) session
                .getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<String, CartItem>();
        }
        if (cart.containsKey(flowerId)) {
            CartItem cartItem = cart.get(flowerId);
            cartItem.setCount(cartItem.getCount()+ 1);
        } else {
            CartItem cartItem = new CartItem();
            Flower flower = flowerService.selectOne(flowerId);
            cartItem.setFlower(flower);
            cartItem.setCount(1);
            // 存放到map中去
            cart.put(flowerId, cartItem);
            session.setAttribute("cart", cart);
        }
        calcMoney();
        return Action.SUCCESS;
    }
    /**
     * 前台:删除购物车
     * @return
     */
    public String delete(){
        // 获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        // 从session中获取购物车数据的map
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        cart.remove(flowerId);
        if (cart.isEmpty()) {
            session.removeAttribute("cart");
        }
        calcMoney();
        return Action.SUCCESS;
    }

    /**
     * 更新购物车
     * @return
     */
    public String update(){
        // 获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        // 从session中获取购物车数据的map
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        CartItem cartItem = (CartItem) cart.get(flowerId);
        //更新图书的数量
        cartItem.setCount(num);
        calcMoney();
        return Action.SUCCESS;
    }

    /**
     * 计算总的金额和节省的金额
     *
     * @return
     */
    public static void calcMoney() {
        // 获取session
        HttpSession session = ServletActionContext.getRequest().getSession();
        // 从session中获取购物车数据的map
        @SuppressWarnings("unchecked")
        Map<String, CartItem> cart = (Map<String, CartItem>) session
                .getAttribute("cart");
        // 总金额
        Double total = 0d;
        // 节省的金额
        Double save = 0d;
        // 遍历map
        if(cart!=null){
            for (Map.Entry<String, CartItem> entry : cart.entrySet()) {
                CartItem cartItem = (CartItem) entry.getValue();
                total += cartItem.getFlower().getMyprice() * cartItem.getCount();
                save += cartItem.getCount()
                        * (cartItem.getFlower().getPrice() - cartItem.getFlower()
                        .getMyprice());
            }
        }
        session.setAttribute("total", total);
        session.setAttribute("save", save);
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
