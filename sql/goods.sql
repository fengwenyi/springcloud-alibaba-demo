CREATE TABLE `t_goods` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) COMMENT '商品名称',
    `price` decimal(11, 2) COMMENT '商品价格',
    `residue` int(11) COMMENT '剩余库存',
    `create_time` datetime COMMENT '创建时间',
    `update_time` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

INSERT INTO `goods` (`id`, `name`, `price`, `residue`, `create_time`) VALUES (1, '小米手机', 2000.00, 1000, '2021-04-10 23:00:00');