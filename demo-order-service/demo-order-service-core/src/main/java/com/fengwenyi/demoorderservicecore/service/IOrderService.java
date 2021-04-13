package com.fengwenyi.demoorderservicecore.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demoorderservicecore.vo.CreateOrderRequestVo;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
public interface IOrderService {

    /**
     * 创建订单
     * @param requestVo 创建订单请求参数 {@link CreateOrderRequestVo}
     * @return 返回创建订单结果
     */
    ResultTemplate<String> create(CreateOrderRequestVo requestVo);

}
