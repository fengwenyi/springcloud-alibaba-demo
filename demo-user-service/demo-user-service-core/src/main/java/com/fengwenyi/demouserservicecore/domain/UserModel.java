package com.fengwenyi.demouserservicecore.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
@Data
@Accessors(chain = true)
public class UserModel implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
