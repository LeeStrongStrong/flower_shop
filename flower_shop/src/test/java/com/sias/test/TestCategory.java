package com.sias.test;

import com.sias.dao.CategoryDao;
import com.sias.entity.Category;
import com.sias.util.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * 测试鲜花类别的dao方法
 */
public class TestCategory {
    /**
     * 测试查所有
     */
    @Test
    public void testSelectAll(){
        CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
        List<Category> categories = categoryDao.selectAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }
    /**
     * 查询一个鲜花类别
     */
    @Test
    public void testSelectOne(){
        CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
        Category category = categoryDao.selectOne("001");
        System.out.println(category);
    }
    /**
     * 添加一个鲜花类别
     */
    @Test
    public void testAdd(){
        CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
        categoryDao.add(new Category("000","道歉鲜花"));
        MybatisUtil.commit();
    }
    /**
     * 删除鲜花类别
     */
    @Test
    public void testDelete(){
        CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
        categoryDao.delete("000");
        MybatisUtil.commit();
    }
    /**
     * 更新鲜花类别
     */
    @Test
    public void testUpdate(){
        CategoryDao categoryDao = MybatisUtil.getSqlSession().getMapper(CategoryDao.class);
        categoryDao.update(new Category("005","特价花蕊"));
        MybatisUtil.commit();
    }
}
