package com.fengwenyi.demoorderservicecore.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fengwenyi.api.result.ResultTemplate;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-12
 */
public class CustomerBlockHandler {

    public static ResultTemplate<?> handleException(BlockException exception) {
        return ResultTemplate.fail(exception.getMessage());
    }

}
