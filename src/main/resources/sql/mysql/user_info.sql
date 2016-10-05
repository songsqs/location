
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_info_id` varchar(32) NOT NULL COMMENT '用户信息表主键,一般为手机号',
  `gender` varchar(16) DEFAULT NULL COMMENT '性别,男 女',
  `is_local` varchar(8) DEFAULT NULL COMMENT '是否为上海本地人',
  `profession` varchar(32) DEFAULT NULL COMMENT '职业',
  `purpose` varchar(32) DEFAULT NULL COMMENT '来上海的目的',
  `age_group` varchar(32) DEFAULT NULL COMMENT '年龄段',
  `peer_num` int(11) DEFAULT NULL COMMENT '同行人数',
  `companion` varchar(64) DEFAULT NULL COMMENT '和谁一起来旅游',
  `income` varchar(32) DEFAULT NULL COMMENT '月收入',
  `province` varchar(32) DEFAULT NULL COMMENT '所在省份',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '开始旅游日期',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '结束旅游日期',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';
