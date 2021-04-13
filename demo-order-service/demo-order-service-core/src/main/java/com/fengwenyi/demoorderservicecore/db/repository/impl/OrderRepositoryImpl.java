package com.fengwenyi.demoorderservicecore.db.repository.impl;

import com.fengwenyi.demoorderservicecore.db.entity.OrderEntity;
import com.fengwenyi.demoorderservicecore.db.dao.IOrderDao;
import com.fengwenyi.demoorderservicecore.db.repository.MPOrderRepository;
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
public class OrderRepositoryImpl extends ServiceImpl<IOrderDao, OrderEntity> implements MPOrderRepository {

}
