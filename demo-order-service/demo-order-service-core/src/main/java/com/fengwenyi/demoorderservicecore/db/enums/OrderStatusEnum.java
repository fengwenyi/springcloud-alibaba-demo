package com.fengwenyi.demoorderservicecore.db.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
@Getter
public enum OrderStatusEnum implements IEnum<Integer> {

    TO_PAY(0, "待支付"),
    PAID(1, "已支付")
    ;

    private final Integer code;

    private final String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
