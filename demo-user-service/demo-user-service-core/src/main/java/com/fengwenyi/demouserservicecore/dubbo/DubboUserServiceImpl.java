package com.fengwenyi.demouserservicecore.dubbo;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demouserserviceapi.service.IDubboUserService;
import com.fengwenyi.demouserservicecore.service.IUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
//@DubboService(version = "1.0.0", group = "springcloud-alibaba-demo")
@DubboService
public class DubboUserServiceImpl implements IDubboUserService {

    @Autowired
    private IUserService userService;

    @Override
    public ResultTemplate<?> getUserById(Integer id) {
        return ResultTemplate.success(userService.queryById(id));
    }
}
