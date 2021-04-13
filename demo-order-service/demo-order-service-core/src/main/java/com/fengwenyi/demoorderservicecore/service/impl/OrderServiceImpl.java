package com.fengwenyi.demoorderservicecore.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demogoodsserviceapi.service.IDubboGoodsService;
import com.fengwenyi.demogoodsserviceapi.vo.GoodsResponseVo;
import com.fengwenyi.demoorderservicecore.db.entity.OrderEntity;
import com.fengwenyi.demoorderservicecore.db.enums.OrderStatusEnum;
import com.fengwenyi.demoorderservicecore.db.repository.MPOrderRepository;
import com.fengwenyi.demoorderservicecore.service.IOrderService;
import com.fengwenyi.demoorderservicecore.vo.CreateOrderRequestVo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @DubboReference
    private IDubboGoodsService dubboGoodsService;

    @Autowired
    private MPOrderRepository mpOrderRepository;

    @Override
    //@Transactional
    @GlobalTransactional(name = "fx-create-order",rollbackFor = Exception.class)
    public ResultTemplate<String> create(CreateOrderRequestVo requestVo) {

        log.info("-----------------------> 交易开始");

        if (Objects.isNull(requestVo)) {
            return ResultTemplate.fail("创建订单参数不能为空");
        }

        // 查询商品
        GoodsResponseVo goodsResponseVo = getGoods(requestVo.getGoodsId());

        if (Objects.isNull(goodsResponseVo)) {
            return ResultTemplate.fail("无该商品，请检查商品ID");
        }

        // 构建订单数据
        OrderEntity orderEntity = buildOrderEntity(requestVo, goodsResponseVo);

        // 创建订单
        log.info("-----------------------> 创建订单开始");
        saveOrder(orderEntity);
        log.info("-----------------------> 创建订单结束");

        // 扣减库存
        log.info("-----------------------> 远程扣减库存开始");
        decreaseGoods(goodsResponseVo.getId(), requestVo.getNum());
        log.info("-----------------------> 远程扣减库存结束");

        log.info("-----------------------> 交易结束");

        return ResultTemplate.success(orderEntity.getId() + "");
    }

    // 扣减商品库存
    private void decreaseGoods(Long goodsId, Integer num) {
        ResultTemplate<Void> resultTemplate = dubboGoodsService.decrease(goodsId, num);
        if (Objects.isNull(resultTemplate)
                || !resultTemplate.getSuccess()) {
            log.error("goods decrease failed");
            throw new RuntimeException("远程扣减库存失败");
        }
    }

    // 保存订单
    private void saveOrder(OrderEntity orderEntity) {
        boolean result = mpOrderRepository.save(orderEntity);
        if (!result) {
            log.error("order save failed");
            throw new RuntimeException("订单保存失败");
        }
    }

    // 构建订单数据
    private OrderEntity buildOrderEntity(CreateOrderRequestVo requestVo, GoodsResponseVo goodsResponseVo) {
        return new OrderEntity()
                .setGoodsId(goodsResponseVo.getId())
                .setCount(requestVo.getNum())
                .setAmounts(goodsResponseVo.getPrice().multiply(new BigDecimal(requestVo.getNum())))
                .setUserId(requestVo.getUserId())
                .setCreateTime(LocalDateTime.now())
                .setStatus(OrderStatusEnum.TO_PAY)
                ;
    }

    // 查询商品信息
    private GoodsResponseVo getGoods(Long goodsId) {
        ResultTemplate<GoodsResponseVo> resultTemplate = dubboGoodsService.getById(goodsId);
        if (!Objects.isNull(resultTemplate) && resultTemplate.getSuccess()) {
            return resultTemplate.getBody();
        }

        if (!Objects.isNull(resultTemplate)) {
            log.error("query goods failed, case: {}", resultTemplate.getMessage());
        }

        return null;
    }
}
