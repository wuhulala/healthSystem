/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.10 : Database - health
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`health` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `health`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_combo` */

DROP TABLE IF EXISTS `tb_combo`;

CREATE TABLE `tb_combo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '套餐名称',
  `price` double NOT NULL COMMENT '套餐价格',
  `picture` varchar(200) DEFAULT NULL COMMENT '套餐首页',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_combo_project` */

DROP TABLE IF EXISTS `tb_combo_project`;

CREATE TABLE `tb_combo_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `combo_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial_number` varchar(20) DEFAULT NULL,
  `combo_name` varchar(50) DEFAULT NULL,
  `org_name` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `exam_time` datetime DEFAULT NULL,
  `price` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `extra_info` varchar(1000) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_organization` */

DROP TABLE IF EXISTS `tb_organization`;

CREATE TABLE `tb_organization` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_project` */

DROP TABLE IF EXISTS `tb_project`;

CREATE TABLE `tb_project` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `comments` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `card_id` varchar(30) DEFAULT NULL,
  `card_type` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `is_married` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/* Trigger structure for table `tb_order` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `order_serial_number` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `order_serial_number` BEFORE INSERT ON `tb_order` FOR EACH ROW 
BEGIN
  declare n int;
   select IFNULL(max(right(serial_number,6)),0) into n from tb_order where mid(serial_number,1,8)=DATE_FORMAT(CURDATE(),'%Y%m%d');
   set NEW.serial_number=concat(DATE_FORMAT(CURDATE(),'%Y%m%d'),right(1000001+n,6));
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
