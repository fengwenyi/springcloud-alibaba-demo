package com.fengwenyi.demouserservicecore.db.repository.impl;

import com.fengwenyi.demouserservicecore.db.entity.UserEntity;
import com.fengwenyi.demouserservicecore.db.dao.IUserDao;
import com.fengwenyi.demouserservicecore.db.repository.MPUserRepository;
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
public class UserRepositoryImpl extends ServiceImpl<IUserDao, UserEntity> implements MPUserRepository {

}
