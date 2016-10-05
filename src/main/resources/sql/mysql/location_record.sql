
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for location_record
-- ----------------------------
DROP TABLE IF EXISTS `location_record`;
CREATE TABLE `location_record` (
  `location_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_info_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户主键id,用以关联信息',
  `longitude` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '纬度',
  `lac` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cid` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `bssid` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `phone_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机型号',
  `network_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '网络类型		',
  `payment` tinyint(1) DEFAULT '0' COMMENT '此条记录是否已经发放红包(0未发放,1已发放)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`location_record_id`),
  KEY `idx_create_time` (`create_time`) USING BTREE,
  KEY `idx_user_info_id` (`user_info_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息记录表';
