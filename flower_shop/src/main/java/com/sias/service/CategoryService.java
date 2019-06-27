package com.sias.service;

import com.sias.entity.Category;

import java.util.List;

/**
 * 类别的service业务方法
 */
public interface CategoryService {
    /**
     * 后台：查询所有类别
     */
    List<Category> selectAll();

    /**
     *后台：根据id查询类别的等级
     * @return 返回这个id所对应的类别
     */
    Category selectOne(String id);

    /**
     * 后台：添加类别信息
     * @param category 接受前台的类别对象信息
     */
    void add(Category category);
    /**
     * 后台：更新类别信息
     */
    void update(Category category);
    /**
     * 后台：删除类别信息
     */
    void remove(String id);

    void removeCategory(String id);
}
