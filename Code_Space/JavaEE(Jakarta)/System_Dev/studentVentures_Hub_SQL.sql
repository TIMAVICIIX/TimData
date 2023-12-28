/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.13 : Database - studentventures_hub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentventures_hub` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `studentventures_hub`;

/*Table structure for table `dictionaryclass_publicventures` */

DROP TABLE IF EXISTS `dictionaryclass_publicventures`;

CREATE TABLE `dictionaryclass_publicventures` (
  `VentureCode` varchar(64) NOT NULL,
  `VentureName` varchar(64) NOT NULL,
  `VentureStartDate` varchar(64) NOT NULL,
  `VentureEndDate` varchar(64) NOT NULL,
  PRIMARY KEY (`VentureCode`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `dictionaryclass_publicventures` */

insert  into `dictionaryclass_publicventures`(`VentureCode`,`VentureName`,`VentureStartDate`,`VentureEndDate`) values ('20240101','元旦','01-01 00:00','01-02 00:00'),('20240210','春节','02-10 00:00','02-18 00:00'),('20240404','清明节','04-04 00:00','04-07 00:00'),('20240501','劳动节','05-01 00:00','05-06 00:00'),('20240610','端午节','06-10 00:00','06-11 00:00'),('20240917','中秋节','09-15 00:00','09-18 00:00'),('20241001','国庆节','10-01 00:00','10-11 00:00');

/*Table structure for table `infoclass_classes` */

DROP TABLE IF EXISTS `infoclass_classes`;

CREATE TABLE `infoclass_classes` (
  `ClassCode` varchar(64) NOT NULL,
  `SpecialityCode` varchar(64) NOT NULL,
  `ClassStartTime` varchar(64) NOT NULL,
  `SpecialityName` varchar(64) NOT NULL,
  `ClassName` varchar(64) NOT NULL,
  PRIMARY KEY (`ClassCode`),
  KEY `idx_className` (`ClassName`),
  KEY `idx_classCode_className` (`ClassCode`,`ClassName`),
  KEY `FK_infoclass_classes` (`SpecialityCode`),
  KEY `FK_infoclass_classes_spec` (`SpecialityName`,`SpecialityCode`),
  CONSTRAINT `FK_infoclass_classes_spec` FOREIGN KEY (`SpecialityName`, `SpecialityCode`) REFERENCES `infoclass_specialitys` (`SpecialityName`, `SpecialityCode`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `infoclass_classes` */

insert  into `infoclass_classes`(`ClassCode`,`SpecialityCode`,`ClassStartTime`,`SpecialityName`,`ClassName`) values ('52201012101','5220101','2021','软件工程','B21软件工程1班'),('52201012201','5220101','2022','软件工程','B22软件工程1班'),('52201042132','5220104','2021','人工智能','B21人工智能1班'),('52203592114','5220359','2021','数学与应用数学','B21数学1班'),('52213012101','5221301','2021','摇滚乐','B21摇滚乐1班'),('52213012102','5221301','2021','摇滚乐','B21摇滚乐2班'),('52213012199','5221301','2021','摇滚乐','B21樱高摇滚班'),('52213032101','5221303','2021','动画','B21动画1班'),('52213032102','5221303','2021','动画','B21动画2班');

/*Table structure for table `infoclass_colleges` */

DROP TABLE IF EXISTS `infoclass_colleges`;

CREATE TABLE `infoclass_colleges` (
  `CollegeCode` varchar(64) NOT NULL,
  `CollegeName` varchar(64) NOT NULL,
  PRIMARY KEY (`CollegeCode`),
  KEY `idx_collegeName` (`CollegeName`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `infoclass_colleges` */

insert  into `infoclass_colleges`(`CollegeCode`,`CollegeName`) values ('52211','电子与通信工程学院'),('52208','法学院'),('52206','化学与化工学院'),('52212','环境与资源学院'),('52201','计算机与信息学院'),('52210','建筑与设计学院'),('52209','经济与管理学院'),('52204','马克思主义学院'),('52207','生命科学学院'),('52203','数学与统计学院'),('52202','外国语学院'),('52205','物理学院'),('52214','医学与健康学院'),('52213','艺术与音乐学院');

/*Table structure for table `infoclass_posters` */

DROP TABLE IF EXISTS `infoclass_posters`;

CREATE TABLE `infoclass_posters` (
  `PosterCode` varchar(64) NOT NULL,
  `PosterName` varchar(64) NOT NULL,
  `ManageTarget` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `CookieCode` varchar(64) NOT NULL,
  PRIMARY KEY (`PosterCode`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `infoclass_posters` */

insert  into `infoclass_posters`(`PosterCode`,`PosterName`,`ManageTarget`,`password`,`CookieCode`) values ('52284000','全局管理员','52200','123456','9mDj%NRgg9OlEdO#yg'),('52284001','喜多郁代','52213','bandrock','CybZ#jOpbqk0oCGPpS');

/*Table structure for table `infoclass_readyattends` */

DROP TABLE IF EXISTS `infoclass_readyattends`;

CREATE TABLE `infoclass_readyattends` (
  `attendCode` varchar(64) NOT NULL,
  `attendName` varchar(64) NOT NULL,
  `attendSex` varchar(64) NOT NULL,
  `enrollDate` varchar(64) NOT NULL,
  `targetCollege` varchar(64) NOT NULL,
  `targetSpec` varchar(64) NOT NULL,
  `targetClass` varchar(64) NOT NULL,
  `telephone` varchar(64) NOT NULL,
  `attendState` varchar(64) NOT NULL,
  `attendPassword` varchar(64) NOT NULL,
  PRIMARY KEY (`attendCode`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `infoclass_readyattends` */

insert  into `infoclass_readyattends`(`attendCode`,`attendName`,`attendSex`,`enrollDate`,`targetCollege`,`targetSpec`,`targetClass`,`telephone`,`attendState`,`attendPassword`) values ('WQXADv6mEa','中野梓','女','2023','52213','5221301','52213012101','18785470348','待入学','N15j2Qjmtd');

/*Table structure for table `infoclass_specialitys` */

DROP TABLE IF EXISTS `infoclass_specialitys`;

CREATE TABLE `infoclass_specialitys` (
  `SpecialityCode` varchar(64) NOT NULL,
  `CollegeCode` varchar(64) NOT NULL,
  `SpecialityName` varchar(64) NOT NULL,
  PRIMARY KEY (`SpecialityCode`),
  KEY `FK_infoclass_specialtys` (`CollegeCode`),
  KEY `idx_speciality` (`SpecialityName`,`SpecialityCode`),
  CONSTRAINT `FK_infoclass_specialtys` FOREIGN KEY (`CollegeCode`) REFERENCES `infoclass_colleges` (`CollegeCode`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `infoclass_specialitys` */

insert  into `infoclass_specialitys`(`SpecialityCode`,`CollegeCode`,`SpecialityName`) values ('5220101','52201','软件工程'),('5220102','52201','数据科学'),('5220103','52201','网络工程'),('5220104','52201','人工智能'),('5220105','52201','信息安全'),('5220201','52202','英语'),('5220202','52202','法语'),('5220203','52202','西班牙语'),('5220204','52202','日语'),('5220205','52202','汉语国际教育'),('5220301','52203','数学'),('5220302','52203','统计学'),('5220303','52203','金融数学'),('5220304','52203','应用统计'),('5220305','52203','运筹学'),('5220359','52203','数学与应用数学'),('5220401','52204','马克思主义理论'),('5220402','52204','思想政治教育'),('5220403','52204','党史与党建'),('5220404','52204','政治经济学'),('5220405','52204','科学社会主义'),('5220501','52205','物理学'),('5220502','52205','应用物理学'),('5220503','52205','电子科学与技术'),('5220504','52205','核物理'),('5220505','52205','光电子技术'),('5220601','52206','化学'),('5220602','52206','材料化学'),('5220603','52206','应用化学'),('5220604','52206','化学工程与工艺'),('5220605','52206','制药工程'),('5220701','52207','生物科学'),('5220702','52207','生物技术'),('5220703','52207','生物信息学'),('5220704','52207','生态学'),('5220705','52207','环境生态学'),('5220801','52208','法学'),('5220802','52208','知识产权法'),('5220803','52208','国际法'),('5220804','52208','行政法'),('5220805','52208','刑法'),('5220901','52209','经济学'),('5220902','52209','金融学'),('5220903','52209','国际经济与贸易'),('5220904','52209','工商管理'),('5220905','52209','市场营销'),('5221001','52210','建筑学'),('5221002','52210','城市规划'),('5221003','52210','风景园林'),('5221004','52210','室内设计'),('5221005','52210','数字媒体艺术'),('5221101','52211','电子信息工程'),('5221102','52211','通信工程'),('5221103','52211','电气工程及其自动化'),('5221104','52211','集成电路设计与集成系统'),('5221105','52211','物联网工程'),('5221201','52212','环境工程'),('5221202','52212','资源环境科学'),('5221203','52212','地理信息科学'),('5221204','52212','野生动物与自然保护区管理'),('5221205','52212','水利工程'),('5221301','52213','摇滚乐'),('5221302','52213','视觉传达设计'),('5221303','52213','动画'),('5221304','52213','戏剧与影视学'),('5221305','52213','广告学'),('5221315','52213','吹奏乐'),('5221401','52214','临床医学'),('5221402','52214','护理学'),('5221403','52214','医学影像学'),('5221404','52214','口腔医学'),('5221405','52214','康复治疗学');

/*Table structure for table `infoclass_students` */

DROP TABLE IF EXISTS `infoclass_students`;

CREATE TABLE `infoclass_students` (
  `StudentCode` varchar(64) NOT NULL,
  `ClassCode` varchar(64) NOT NULL,
  `CollegeName` varchar(64) NOT NULL,
  `ClassName` varchar(64) NOT NULL,
  `StudentName` varchar(64) NOT NULL,
  `StudentSex` varchar(64) NOT NULL,
  `EnrollTime` varchar(64) NOT NULL,
  `Telephone` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `StudentState` varchar(64) NOT NULL,
  `CookieCode` varchar(64) NOT NULL,
  PRIMARY KEY (`StudentCode`),
  KEY `FK_infoclass_students` (`ClassCode`,`ClassName`),
  KEY `FK_infoclass_students_collegeName` (`CollegeName`),
  CONSTRAINT `FK_infoclass_students` FOREIGN KEY (`ClassCode`, `ClassName`) REFERENCES `infoclass_classes` (`ClassCode`, `ClassName`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `infoclass_students` */

insert  into `infoclass_students`(`StudentCode`,`ClassCode`,`CollegeName`,`ClassName`,`StudentName`,`StudentSex`,`EnrollTime`,`Telephone`,`password`,`StudentState`,`CookieCode`) values ('20101210145','52201012101','计算机与信息学院','B21软件工程1班','吴子豪','男','2021','15885475391','sVYjuNlA','正常','DWA4F6AWE'),('21301210101','52213012101','艺术与音乐学院','B21摇滚乐1班','平泽唯','女','2021','11451419198','kon!','正常','dwafwa'),('21301210124','52213012101','艺术与音乐学院','B21摇滚乐1班','山田凉','女','2021','03198834408','youqianle','正常','$Q0OgbYEsRDflkdD55'),('21301210199','52213012101','艺术与音乐学院','B21摇滚乐1班','伊地知虹夏','女','2021','54499647333','YyAjrdHW','正常','botBzb4agsIJdkRUpg');

/*Table structure for table `ventureclass_records` */

DROP TABLE IF EXISTS `ventureclass_records`;

CREATE TABLE `ventureclass_records` (
  `studentCode` varchar(64) NOT NULL,
  `ventureCode` varchar(64) NOT NULL,
  `ventureName` varchar(64) NOT NULL,
  `studentName` varchar(64) NOT NULL,
  `destination` varchar(64) NOT NULL,
  `ventureDes` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `ventureclass_records` */

insert  into `ventureclass_records`(`studentCode`,`ventureCode`,`ventureName`,`studentName`,`destination`,`ventureDes`) values ('21301210124','52213012101231230','学院祭特批假期','山田凉','贵州 黔南布依族苗族自治州 瓮安县##瓮安县-星歌乐吧','进行付费表演!(带上波奇酱，kita酱和小虹夏，还有广田菊里姐姐)'),('21301210124','52213000000240501','艺术学院劳动节','山田凉','贵州 黔南布依族苗族自治州 都匀市##在学校打扫捏','但是我会摸鱼的！(大拇哥)'),('21301210124','52200000000240314','2024植树节','山田凉','北京 市辖区 朝阳区##被指派到首都进行植树咯！','咱学院太给力了！'),('21301210101','52213012101231230','学院祭特批假期','平泽唯','上海 市辖区 黄浦区 ##黄浦区樱丘高等学校','举行乐队表演竞赛'),('21301210101','52213000000240501','艺术学院劳动节','平泽唯','重庆 市辖区 巴南区 ##巴南区-轻音同好祭','准备坐高铁去，和轻音部的大家一起'),('21301210199','52213012101231230','学院祭特批假期','伊地知虹夏','贵州 黔南布依族苗族自治州 瓮安县 ##瓮安县-星歌乐吧','结束乐队需要我当鼓手！'),('21301210199','52200000000231230','寒假','伊地知虹夏','北京 市辖区 朝阳区 ##朝阳区-朝阳艺术厅','和姐姐一起去听交响乐！');

/*Table structure for table `ventureclass_ventures` */

DROP TABLE IF EXISTS `ventureclass_ventures`;

CREATE TABLE `ventureclass_ventures` (
  `VentureCode` varchar(64) NOT NULL,
  `VentureName` varchar(64) NOT NULL,
  `VentureStartDate` varchar(64) NOT NULL,
  `VentureEndDate` varchar(64) NOT NULL,
  `VentureBelongCollege` varchar(64) NOT NULL,
  `VentureBelongSpec` varchar(64) NOT NULL,
  `VentureBelongClass` varchar(64) NOT NULL,
  `VentureType` varchar(64) NOT NULL,
  `VentureDes` varchar(64) NOT NULL,
  PRIMARY KEY (`VentureCode`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `ventureclass_ventures` */

insert  into `ventureclass_ventures`(`VentureCode`,`VentureName`,`VentureStartDate`,`VentureEndDate`,`VentureBelongCollege`,`VentureBelongSpec`,`VentureBelongClass`,`VentureType`,`VentureDes`) values ('52200000000230101','2023寒假','2023-01-01','2023-02-28','全体学院','全体专业','全体班级','国家标准假期',''),('52200000000231230','寒假','2023-12-30','2024-02-28','全体学院','全体专业','全体班级','国家标准假期','全体学院的寒假假期！'),('52200000000240202','2024除夕','2024-02-02','2024-02-04','全体学院','全体专业','全体班级','国家标准假期',''),('52200000000240314','2024植树节','2024-03-14','2024-03-14','全体学院','全体专业','全体班级','国家标准假期',''),('52201012101230101','元旦节','2023-01-01','2023-01-02','计算机与信息学院','软件工程','B21软件工程1班','班级指定假期','元旦放假'),('52213000000240501','艺术学院劳动节','2024-05-01','2024-05-05','艺术与音乐学院','全体专业','全体班级','国家标准假期',''),('52213012101231230','学院祭特批假期','2023-12-30','2023-12-31','艺术与音乐学院','摇滚乐','B21摇滚乐1班','班级指定假期','学院祭的假期，是举行学院活动的日子!'),('52213012199231225','轻音部合宿假期','2023-12-25','2023-12-26','艺术与音乐学院','摇滚乐','B21樱高摇滚班','其他假期','轻音社特批合宿假期！\n成员：平泽唯，中野梓，田中井律，秋山凛，琴吹绸。');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
