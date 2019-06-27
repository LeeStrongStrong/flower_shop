package com.sias.service;

import com.sias.entity.Flower;

import java.util.List;

/**
 * 鲜花的service业务方法
 */
public interface FlowerService {
    /**
     * 随机推荐
     * @return
     */
    List<Flower> selectFlowerByRecommend();

    /**
     * 前台:根据类别查询鲜花
     */
    List<Flower> selectFlowerByCategoryId(String categoryId);

    /**
     * 前台:查询销量前8的鲜花信息
     */
    List<Flower> selectBySale();
    /*******************************************************************************/

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
     * 模糊查询
     */
    List<Flower> findBySth(String key, String content);
}
