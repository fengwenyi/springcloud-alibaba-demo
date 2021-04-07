package com.fengwenyi.demouserserviceapi.service;

import com.fengwenyi.api.result.ResultTemplate;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
public interface IDubboUserService {

    ResultTemplate<?> getUserById(Integer id);

}
