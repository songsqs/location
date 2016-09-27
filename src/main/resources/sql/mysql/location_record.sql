CREATE DATABASE  IF NOT EXISTS `location` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `location`;
-- MySQL dump 10.13  Distrib 5.5.49, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: location
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `location_record`
--

DROP TABLE IF EXISTS `location_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_record` (
  `location_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_info_id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户主键id,用以关联信息',
  `longitude` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '经度',
  `dimension` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '纬度',
  `lac` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `cid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `bssid` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `phone_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机型号',
  `network_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '网络类型		',
  `payment` tinyint(1) DEFAULT '0' COMMENT '此条记录是否已经发放红包(0未发放,1已发放)',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`location_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息记录表';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-27 20:05:02
