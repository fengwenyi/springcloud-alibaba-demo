package com.fengwenyi.demoorderservicecore.vo;

import lombok.Data;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
@Data
public class CreateOrderRequestVo {

    private Long goodsId;

    private Long userId;

    private Integer num;

}
