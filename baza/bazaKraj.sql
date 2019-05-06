/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.14 : Database - dmddatabase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dmddatabase` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dmddatabase`;

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `vin` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `registration` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `production_year` smallint(4) DEFAULT NULL,
  `color` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `client_id` int(10) DEFAULT NULL,
  `model_engine_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_client` (`client_id`),
  KEY `fk_model_engine` (`model_engine_id`),
  CONSTRAINT `fk_client` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_model_engine` FOREIGN KEY (`model_engine_id`) REFERENCES `model_engine` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car` */

insert  into `car`(`id`,`vin`,`registration`,`production_year`,`color`,`client_id`,`model_engine_id`) values (4,'afs c','BG-661-JU',2008,'Yellow',10,12),(5,'dafdd','PK-327-XC',2009,'Pink',8,12),(6,'saddas','BG-123-SK',2001,'Blue',10,12),(7,'sdvsdv','NS-345-BG',2001,'Black',10,12),(8,'4E3BT64U1ME040010','NI-1234-MI',2005,'Red',10,10);

/*Table structure for table `car_brand` */

DROP TABLE IF EXISTS `car_brand`;

CREATE TABLE `car_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `country` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car_brand` */

insert  into `car_brand`(`id`,`name`,`country`) values (1,'Alfa Romeo','Italy'),(2,'Audi','Germany'),(3,'Fiat','Italy'),(4,'Toyota','Japan');

/*Table structure for table `car_brand_model` */

DROP TABLE IF EXISTS `car_brand_model`;

CREATE TABLE `car_brand_model` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `production_began` smallint(4) DEFAULT NULL,
  `production_end` smallint(4) DEFAULT NULL,
  `carbrand_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `carbrand_id` (`carbrand_id`),
  CONSTRAINT `car_brand_model_ibfk_1` FOREIGN KEY (`carbrand_id`) REFERENCES `car_brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car_brand_model` */

insert  into `car_brand_model`(`id`,`name`,`production_began`,`production_end`,`carbrand_id`) values (1,'A4',2004,2007,2),(2,'A6',2012,2015,2),(3,'Giulietta',2010,2014,1),(4,'Brera',2006,2010,1),(5,'Multipla',2000,2010,3),(6,'Stilo',2002,2007,3);

/*Table structure for table `car_part` */

DROP TABLE IF EXISTS `car_part`;

CREATE TABLE `car_part` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `price` double(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car_part` */

insert  into `car_part`(`id`,`name`,`price`) values (1,'Storno',NULL),(2,'Kociona plocica',8.00),(3,'Leteci lezaj',20.00),(4,'PK Kais',16.00),(6,'Dihtung glave',28.15);

/*Table structure for table `chapter` */

DROP TABLE IF EXISTS `chapter`;

CREATE TABLE `chapter` (
  `BOOK_ISBN` varchar(50) NOT NULL,
  `CHAPTER_NUM` int(11) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  PRIMARY KEY (`BOOK_ISBN`,`CHAPTER_NUM`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `chapter` */

/*Table structure for table `engine` */

DROP TABLE IF EXISTS `engine`;

CREATE TABLE `engine` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fuel` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `kw` int(5) DEFAULT NULL,
  `hp` int(5) DEFAULT NULL,
  `volume` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `engine` */

insert  into `engine`(`id`,`name`,`fuel`,`kw`,`hp`,`volume`) values (1,'1.9 JTD','Diesel',85,116,1910),(2,'1.3 MJET','Diesel',66,90,1300),(3,'1.8 TFSI','Petrol',118,160,1798);

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` int(5) NOT NULL,
  `repair_id` int(10) NOT NULL,
  `amount` double(10,2) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `car_part_id` int(10) DEFAULT NULL,
  `service_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`,`repair_id`),
  KEY `fk_car_part` (`car_part_id`),
  KEY `fk_service` (`service_id`),
  KEY `fk_repair` (`repair_id`),
  CONSTRAINT `fk_car_part` FOREIGN KEY (`car_part_id`) REFERENCES `car_part` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_repair` FOREIGN KEY (`repair_id`) REFERENCES `repair` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `item` */

insert  into `item`(`id`,`repair_id`,`amount`,`price`,`car_part_id`,`service_id`) values (1,26,1.00,80.00,NULL,8),(1,27,1.00,80.00,NULL,8),(1,28,1.00,80.00,NULL,8),(1,29,1.00,80.00,NULL,8),(1,30,1.00,80.00,NULL,8),(1,31,4.00,48.00,2,NULL),(1,32,1.00,80.00,NULL,8),(1,33,2.00,16.00,2,NULL),(1,34,1.00,60.00,NULL,8),(1,35,1.00,0.00,1,NULL),(1,36,4.00,120.00,NULL,11),(1,37,1.00,60.00,NULL,8),(2,26,4.00,28.00,2,NULL),(2,27,2.00,24.00,3,NULL),(2,28,4.00,16.00,2,NULL),(2,30,1.00,4.00,4,NULL),(2,32,4.00,444.00,2,NULL),(2,33,1.00,40.00,NULL,10),(2,34,4.00,32.00,2,NULL),(2,36,4.00,32.00,2,NULL),(2,37,4.00,32.00,2,NULL),(3,26,1.00,3.00,4,NULL),(3,32,1.00,-524.00,1,NULL),(3,34,1.00,16.00,4,NULL),(4,26,1.00,3.00,3,NULL),(5,26,1.00,1.00,4,NULL),(6,26,1.00,1.00,4,NULL),(7,26,1.00,4.00,4,NULL);

/*Table structure for table `model_engine` */

DROP TABLE IF EXISTS `model_engine`;

CREATE TABLE `model_engine` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `model_id` int(10) DEFAULT NULL,
  `engine_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `model_id` (`model_id`,`engine_id`),
  KEY `fk_engine` (`engine_id`),
  CONSTRAINT `fk_engine` FOREIGN KEY (`engine_id`) REFERENCES `engine` (`id`),
  CONSTRAINT `fk_model` FOREIGN KEY (`model_id`) REFERENCES `car_brand_model` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `model_engine` */

insert  into `model_engine`(`id`,`model_id`,`engine_id`) values (9,1,1),(10,1,3),(12,4,1),(11,4,2),(8,5,1);

/*Table structure for table `repair` */

DROP TABLE IF EXISTS `repair`;

CREATE TABLE `repair` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `datum` date DEFAULT NULL,
  `kilometers` int(10) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `car_id` int(10) DEFAULT NULL,
  `shop_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_car` (`car_id`),
  KEY `fk_shop` (`shop_id`),
  CONSTRAINT `fk_car` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_shop` FOREIGN KEY (`shop_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `repair` */

insert  into `repair`(`id`,`datum`,`kilometers`,`is_active`,`price`,`car_id`,`shop_id`) values (26,NULL,1231239911,'',120.00,4,7),(27,NULL,123123,'',104.00,4,0),(28,'2018-12-30',123999,'\0',96.00,4,7),(29,'2019-01-10',123123,'\0',80.00,5,7),(30,'2019-01-16',123456789,'\0',84.00,4,7),(31,NULL,123456,'',48.00,5,7),(32,'2019-02-16',9999,'\0',0.00,5,0),(33,'2019-04-02',567567,'\0',56.00,5,0),(34,NULL,1953523,'',108.00,6,0),(35,'2019-05-02',236841,'\0',0.00,7,0),(36,NULL,236841,'',152.00,7,0),(37,NULL,2612001,'',92.00,8,0);

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `hours` double(6,2) DEFAULT NULL,
  `price` double(6,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `service` */

insert  into `service`(`id`,`name`,`hours`,`price`) values (8,'Veliki Servis',3.00,60.00),(10,'Mali Servis',2.00,40.00),(11,'Zamena Plocica',1.50,30.00),(12,'Reglaza trapa',1.00,20.00);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `naziv` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pib` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `maticni` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jmbg` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TIP` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `naziv` (`naziv`,`pib`,`maticni`,`jmbg`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`naziv`,`pib`,`maticni`,`ime`,`prezime`,`jmbg`,`TIP`) values (0,'marko','marko','marko@alfa.com','amag','19382719','12398471',NULL,NULL,NULL,'S'),(7,'dusan','dusan','dusan.milenkovic191@gmail.com','dusan','dusan','dusan',NULL,NULL,NULL,'S'),(8,'milan','milan','milan@milan.com',NULL,NULL,NULL,'milan','milan','milan','C'),(9,'alex','alex','alex@alex.com','alex','alex','alex',NULL,NULL,NULL,'S'),(10,'milica','milica','milica@milica.com',NULL,NULL,NULL,'milica','milica','milica','C'),(11,'milija','milija','milija@milija.com',NULL,NULL,NULL,'milija','milija','milija','C'),(40,'ana','ana','ana@ana.com','ana','ana','ana',NULL,NULL,NULL,'S');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
