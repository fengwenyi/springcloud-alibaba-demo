package com.fengwenyi.demogoodsservicecore.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demogoodsservicecore.db.entity.GoodsEntity;
import com.fengwenyi.demogoodsservicecore.db.repository.MPGoodsRepository;
import com.fengwenyi.demogoodsservicecore.service.IGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
@Service
@Slf4j
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private MPGoodsRepository mpGoodsRepository;

    @Override
    public GoodsEntity getById(Long id) {
        Assert.notNull(id, "id must not null");
        return mpGoodsRepository.getById(id);
    }

    @Override
    public boolean updateById(GoodsEntity entity) {
        Assert.notNull(entity, "goodsEntity must not null");

        Long id = entity.getId();
        if (Objects.isNull(id)) {
            log.error("update goods failed, case: id is null");
            return Boolean.FALSE;
        }

        if (entity.getResidue() < 0) {
            log.error("update goods failed, case: 商品剩余库存数量不合法");
            return Boolean.FALSE;
        }

        return mpGoodsRepository.updateById(entity);
    }
}
