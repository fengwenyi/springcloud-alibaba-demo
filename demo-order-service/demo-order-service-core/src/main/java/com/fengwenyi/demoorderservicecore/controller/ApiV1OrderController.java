package com.fengwenyi.demoorderservicecore.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demouserserviceapi.service.IDubboUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
@RestController
@RequestMapping("/api/v1/order")
public class ApiV1OrderController {

    // 创建订单
    public ResultTemplate<?> create() {
        return ResultTemplate.fail();
    }

//    @DubboReference(version = "1.0.0", check = false, group = "springcloud-alibaba-demo")
    @DubboReference
    private IDubboUserService dubboUserService;

    @GetMapping("/user")
    public ResultTemplate<?> getUser(Integer id) {
        return dubboUserService.getUserById(id);
    }
}
