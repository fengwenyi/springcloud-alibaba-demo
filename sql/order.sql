CREATE TABLE `t_order` (
     `id` bigint(20) NOT NULL,
     `user_id` bigint(20) COMMENT '用户ID',
     `goods_id` bigint(20) COMMENT '商品ID',
     `count` int(11) COMMENT '数量',
     `amounts` decimal(11, 2) COMMENT '金额',
     `status` tinyint(1) COMMENT '订单状态。0：待支付；1：已支付。',
     `create_time` datetime COMMENT '创建时间',
     `update_time` datetime COMMENT '更新时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;