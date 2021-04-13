package com.fengwenyi.demogoodsserviceapi.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-13
 */
@Data
@Accessors(chain = true)
public class GoodsResponseVo implements Serializable {

    private static final long serialVersionUID = 4737775240952804599L;

    private Long id;

    private String name;

    private BigDecimal price;

    private Integer residue;

}
