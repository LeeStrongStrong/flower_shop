package com.sias.test;

import com.sias.dao.ItermDao;
import com.sias.entity.Flower;
import com.sias.entity.OrderItem;
import com.sias.util.MybatisUtil;
import org.junit.Test;

/**
 * 测试订单项方法
 */
public class TestIterm {
    @Test
    public void test(){
        ItermDao itermDao = MybatisUtil.getSqlSession().getMapper(ItermDao.class);
        Flower flower = new Flower();
        itermDao.addItem(new OrderItem("001","001",1,"002",flower));
    }
}
