package com.fengwenyi.demogoodsservicecore.db.repository.impl;

import com.fengwenyi.demogoodsservicecore.db.entity.GoodsEntity;
import com.fengwenyi.demogoodsservicecore.db.dao.IGoodsDao;
import com.fengwenyi.demogoodsservicecore.db.repository.MPGoodsRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-13
 */
@Service
public class GoodsRepositoryImpl extends ServiceImpl<IGoodsDao, GoodsEntity> implements MPGoodsRepository {

}
