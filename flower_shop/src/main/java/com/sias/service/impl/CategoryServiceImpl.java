package com.sias.service.impl;

import com.sias.dao.CategoryDao;
import com.sias.entity.Category;
import com.sias.entity.Flower;
import com.sias.service.CategoryService;
import com.sias.service.FlowerService;
import com.sias.util.MybatisUtil;

import java.util.List;
import java.util.UUID;

/**
 * 类别的业务层方法实现
 */
public class CategoryServiceImpl implements CategoryService {
    /**
     * 查询所有
     */
    @Override
    public List<Category> selectAll() {
        try{
            CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
            return categoryDao.selectAll();
        }finally{
            MybatisUtil.close();
        }
    }

    /**
     * 查询一个鲜花类别
     * @param  id
     * @return
     */
    @Override
    public Category selectOne(String id) {
        try{
            CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
            return categoryDao.selectOne(id);
        }finally{
            MybatisUtil.close();
        }
    }

    /**
     * 添加
     * @param category
     * 接受前台的类别对象信息
     */
    @Override
    public void add(Category category) {
        try{
            CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
            category.setId(UUID.randomUUID().toString());
            categoryDao.add(category);
            MybatisUtil.commit();
        }catch (Exception e){
            MybatisUtil.rollback();
            e.printStackTrace();
        }
    }

    /**
     * 更新
     * @param category
     */
    @Override
    public void update(Category category) {
        try{
            CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
            categoryDao.update(category);
            MybatisUtil.commit();
        }catch (Exception e){
            MybatisUtil.rollback();
            e.printStackTrace();
        }
    }

    /**
     * 删除
     */
    @Override
    public void remove(String id) {
        try{
            CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
            categoryDao.delete(id);
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
        }
    }
    /**
     *后台：删除类别时处理的业务逻辑
     */
    @Override
    public void removeCategory(String id){
        FlowerService flowerService = new FlowerServiceImpl();
        List<Flower> flowers = flowerService.selectFlowerByCategoryId(id);
        if(flowers.size()==0){
            remove(id);
        }else{
            throw new RuntimeException("删除失败");
        }
    }

}
