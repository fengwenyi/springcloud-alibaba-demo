package com.fengwenyi.demoorderservicecore.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demoorderservicecore.handler.CustomerBlockHandler;
import com.fengwenyi.demouserserviceapi.service.IDubboUserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
@RestController
@RequestMapping(value = "/api/v1/order",
//        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiV1OrderController {

    // 创建订单
    @RequestMapping("/create")
    @GlobalTransactional(name = "demo-create-order",rollbackFor = Exception.class)
    public ResultTemplate<?> create() {
        return ResultTemplate.success();
    }

//    @DubboReference(version = "1.0.0", check = false, group = "springcloud-alibaba-demo")
    @DubboReference
    private IDubboUserService dubboUserService;

    @GetMapping("/user")
    public ResultTemplate<?> getUser(Integer id) {
        return dubboUserService.getUserById(id);
    }

    @GetMapping("/demo")
    public ResultTemplate<?> demo() {
        return ResultTemplate.fail();
    }

    @GetMapping("/sentinel")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handleException")
    public ResultTemplate<?> sentinel() {
        return ResultTemplate.success();
    }

}
