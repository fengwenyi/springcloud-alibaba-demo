package com.fengwenyi.demogoodsservicecore.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("goods")
public class GoodsEntity extends Model<GoodsEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 商品名称
     */
    @TableField("name")
    private String name;

    /**
     * 商品价格
     */
    @TableField("price")
    private BigDecimal price;

    /**
     * 剩余库存
     */
    @TableField("residue")
    private Integer residue;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
