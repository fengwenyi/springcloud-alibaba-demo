package com.fengwenyi.demouserservicecore.service;

import com.fengwenyi.demouserservicecore.domain.UserModel;

import java.util.List;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
public interface IUserService {

    List<UserModel> queryAll();

    UserModel queryById(Integer id);

    boolean updateById(UserModel model);

}
