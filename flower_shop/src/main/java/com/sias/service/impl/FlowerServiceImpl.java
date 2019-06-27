package com.sias.service.impl;

import com.sias.dao.FlowerDao;
import com.sias.entity.Flower;
import com.sias.service.FlowerService;
import com.sias.util.MybatisUtil;

import java.util.List;
import java.util.UUID;

/**
 * 鲜花service业务方法实现
 */
public class FlowerServiceImpl implements FlowerService {
    /**
     * 模糊查询
     * @param key
     * @param content
     * @return
     */
    @Override
    public List<Flower> findBySth(String key, String content) {
       try{
           FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
           return flowerDao.selectBySth(key,content);
       }finally{
           MybatisUtil.close();
       }
    }

    /**
     * 随机推荐
     * @return
     */
    @Override
    public List<Flower> selectFlowerByRecommend() {
       try{
           FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
           return flowerDao.selectFlowerByRecommend();
       }finally {
           MybatisUtil.close();
       }
    }
    /**
     * 前台：根据类别的id查询所属鲜花
     * @param categoryId
     * @return
     */
    @Override
    public List<Flower> selectFlowerByCategoryId(String categoryId) {
       try{
           FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
           return flowerDao.selectFlowerByCategoryId(categoryId);
       }finally {
           MybatisUtil.close();
       }
    }
    /**
     * 根据销量查询前8的鲜花信息
     * @return
     */
    @Override
    public List<Flower> selectBySale() {
        try{
            FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
            return flowerDao.selectBySale();
        }finally {
            MybatisUtil.close();
        }
    }
    /**
     * 后台：查询所有鲜花信息
     * @return
     */
    @Override
    public List<Flower> selectAll() {
        try{
            FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
            return flowerDao.selectAll();
        }finally {
            MybatisUtil.close();
        }
    }
    /**
     * 前后台公用：查询一个鲜花信息
     * @param id
     * @return
     */
    @Override
    public Flower selectOne(String id) {
        try{
            FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
            return flowerDao.selectOne(id);
        }finally {
            MybatisUtil.close();
        }
    }

    /**
     * 后台：添加一个鲜花
     * @param flower
     */
    @Override
    public void add(Flower flower) {
        try{
            FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
            flower.setId(UUID.randomUUID().toString());
            flower.setSale(0);
            flowerDao.add(flower);
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }
    }
    /**
     * 后台：更新鲜花信息
     * @param flower
     */
    @Override
    public void update(Flower flower) {
        try{
            FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
            flowerDao.update(flower);
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }
    }
    /**
     * 删除鲜花信息
     * @param id
     */
    @Override
    public void delete(String id) {
        try{
            FlowerDao flowerDao = MybatisUtil.getSqlSession().getMapper(FlowerDao.class);
            flowerDao.delete(id);
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }
    }
}
