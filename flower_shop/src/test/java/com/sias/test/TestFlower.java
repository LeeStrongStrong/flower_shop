package com.sias.test;

import com.sias.dao.FlowerDao;
import com.sias.entity.Category;
import com.sias.entity.Flower;
import com.sias.util.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * 测试鲜花dao方法
 */
public class TestFlower {
    /**
     * 测试模糊查询
     */
    @Test
    public void testSelectBySth(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        List<Flower> flowers = flowerDao.selectBySth("language", "一");
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }

    /**
     * 测试查所有
     */
    @Test
    public void testSelectAll(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        List<Flower> flowers = flowerDao.selectAll();
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }
    /**
     * 测试查询一个
     */
    @Test
    public void testSelectOne(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        Flower flower = flowerDao.selectOne("001");
        System.out.println(flower);
    }
    /**
     * 测试添加
     */
    @Test
    public void testAdd(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        Category category = new Category();
        Flower flower = new Flower("002","一生有你就好","99朵玫瑰花","flower.png","爱你一生无悔",266.00,200.00,0,"001",category);
        Flower flower1 = new Flower("003","一生有你","99朵玫瑰花","flower.png","爱你一生无悔",266.00,200.00,2,"001",category);
        flowerDao.add(flower);
        flowerDao.add(flower1);
        MybatisUtil.commit();
    }
    /**
     * 测试更新
     */
    @Test
    public void testUpdate(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        Category category = new Category("002", "");
        Flower flower = new Flower("001","一生有你a","99朵玫瑰花","flower.png","爱你一生无悔",266.00,200.00,0,"001",category);
        flowerDao.update(flower);
        MybatisUtil.commit();
    }
    /**
     * 删除
     */
    @Test
    public void testDelete(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        flowerDao.delete("001");
    }
    /**
     * 测试通鲜花销量前8的
     */
    @Test
    public void testSelectBySale(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        List<Flower> flowers = flowerDao.selectBySale();
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }
    /**
     * 测试根据鲜花的id更新销量
     */
    @Test
    public void testUpdateSale(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        flowerDao.updateFlowerSale("001",100);
        MybatisUtil.commit();
    }

    /**
     * 测试根据类别查询鲜花
     */
    @Test
    public void testSelectFlowerByCategoryId(){
        FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
        List<Flower> flowers = flowerDao.selectFlowerByCategoryId("001");
        for (Flower flower : flowers) {
            System.out.println(flower);
        }
    }

}
