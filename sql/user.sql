CREATE TABLE `t_user` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) COMMENT '姓名',
    `balance` decimal(11, 2) COMMENT '余额',
    `create_time` datetime COMMENT '创建时间',
    `update_time` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `name`, `balance`, `create_time`) VALUES (1, 'Zhang San', 100000000.00, '2021-04-10 23:00:00');