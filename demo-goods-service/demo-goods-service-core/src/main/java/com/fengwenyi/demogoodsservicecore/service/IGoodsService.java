package com.fengwenyi.demogoodsservicecore.service;

import com.fengwenyi.demogoodsservicecore.db.entity.GoodsEntity;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
public interface IGoodsService {

    /**
     * 根据ID查询
     * @param id 商品ID
     * @return 返回商品信息
     */
    GoodsEntity getById(Long id);

    /**
     * 根据ID更新商品信息
     * @param entity 商品信息
     * @return 返回更新结果
     */
    boolean updateById(GoodsEntity entity);

}
