package com.fengwenyi.demogoodsserviceapi.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demogoodsserviceapi.vo.GoodsResponseVo;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
public interface IDubboGoodsService {

    /**
     * 根据商品ID查询商品信息
     * @param id 商品ID
     * @return 商品信息 {@link GoodsResponseVo}
     */
    ResultTemplate<GoodsResponseVo> getById(Long id);

    /**
     * 扣减商品库存
     * @param id 商品ID
     * @param num 扣减库存数量
     * @return 扣减库存操作结果
     */
    ResultTemplate<Void> decrease(Long id, Integer num);

}
