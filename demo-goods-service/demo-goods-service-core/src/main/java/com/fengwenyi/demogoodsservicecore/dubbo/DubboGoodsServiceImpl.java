package com.fengwenyi.demogoodsservicecore.dubbo;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demogoodsserviceapi.service.IDubboGoodsService;
import com.fengwenyi.demogoodsserviceapi.vo.GoodsResponseVo;
import com.fengwenyi.demogoodsservicecore.db.entity.GoodsEntity;
import com.fengwenyi.demogoodsservicecore.service.IGoodsService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
@DubboService
public class DubboGoodsServiceImpl implements IDubboGoodsService {

    @Autowired
    private IGoodsService goodsService;

    @Override
    public ResultTemplate<GoodsResponseVo> getById(Long id) {
        if (Objects.isNull(id)) {
            return ResultTemplate.fail("商品ID不能为空");
        }

        GoodsEntity goodsEntity = goodsService.getById(id);
        if (Objects.isNull(goodsEntity)) {
            return ResultTemplate.fail("无该商品");
        }

        GoodsResponseVo goodsResponseVo = new GoodsResponseVo()
                .setId(goodsEntity.getId())
                .setName(goodsEntity.getName())
                .setPrice(goodsEntity.getPrice())
                .setResidue(goodsEntity.getResidue())
                ;

        return ResultTemplate.success(goodsResponseVo);
    }

    @Override
    public ResultTemplate<Void> decrease(Long id, Integer num) {
        if (Objects.isNull(id)) {
            return ResultTemplate.fail("商品ID不能为空");
        }

        if (Objects.isNull(num)) {
            return ResultTemplate.fail("扣减库存数量不能为空");
        }

        GoodsEntity goodsEntity = goodsService.getById(id);
        if (Objects.isNull(goodsEntity)) {
            return ResultTemplate.fail("无该商品");
        }

        if (goodsEntity.getResidue() < num) {
            return ResultTemplate.fail("商品库存不足");
        }

        goodsEntity.setResidue(goodsEntity.getResidue() - num);

        boolean result = goodsService.updateById(goodsEntity);

        if (result) {
            return ResultTemplate.success();
        }

        return ResultTemplate.fail("扣减商品库存失败");
    }
}
