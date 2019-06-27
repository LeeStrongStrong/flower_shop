package com.sias.dao;

import com.sias.entity.Flower;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 鲜花的dao层方法
 */
public interface FlowerDao {
    /**
     * 随机推荐八种花
     */
    List<Flower> selectFlowerByRecommend();
    /**
     * 前台：根据鲜花的id更新销量
     */
    void updateFlowerSale(@Param("id") String id, @Param("count") Integer count);

    /**
     * 前台:根据类别查询鲜花
     */
    List<Flower> selectFlowerByCategoryId(String categoryId);

    /**
     * 前台:查询销量前8的鲜花信息
     * @return 销量前8的鲜花集合
     */
    List<Flower> selectBySale();


    /*******************************************************************/

    /**
     * 后台：查询所有的鲜花信息
     */
    List<Flower> selectAll();

    /**
     * 后台：根据id查询一个鲜花的信息
     */
    Flower selectOne(String id);

    /**
     * 后台：添加鲜花
     * @param flower 接受鲜花对象
     */
    void add(Flower flower);

    /**
     * 后台：修改鲜花信息
     */
    void update(Flower flower);

    /**
     * 后台：删除鲜花信息
     */
    void delete(String id);

    /**
     * 后台:模糊查询
     * @param key 下拉框所选值
     * @param content 输入的查询条件
     * @return 符合条件的图书集合
     */
    List<Flower> selectBySth(@Param("key")String key, @Param("content")String content);
}
