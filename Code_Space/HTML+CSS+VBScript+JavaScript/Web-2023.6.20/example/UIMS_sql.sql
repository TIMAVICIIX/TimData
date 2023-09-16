/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.62 : Database - uims
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`uims` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `uims`;

/*Table structure for table `user_tb` */

DROP TABLE IF EXISTS `user_tb`;

CREATE TABLE `user_tb` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(20) DEFAULT NULL,
  `truename` char(20) DEFAULT NULL,
  `userpassword` char(50) DEFAULT NULL,
  `logindate` datetime DEFAULT NULL,
  `loginip` char(20) DEFAULT NULL,
  `userclass` char(10) DEFAULT NULL,
  `adminpass` int(11) DEFAULT '0',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

/*Data for the table `user_tb` */

insert  into `user_tb`(`userID`,`username`,`truename`,`userpassword`,`logindate`,`loginip`,`userclass`,`adminpass`) values (1,'admin','管理员','123456',NULL,NULL,'管理员',1),(2,'20200801','张三','123456','2023-05-16 00:00:00','::1','学生',1),(3,'20200802','李四','123456','2023-05-16 00:00:00','::1','教师',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
