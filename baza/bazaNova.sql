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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car` */

insert  into `car`(`id`,`vin`,`registration`,`production_year`,`color`,`client_id`,`model_engine_id`) values (4,'afs c','BG-661-JU',2008,'Gray',8,12),(5,'dafdd','PK-327-XC',2009,'Pink',8,12);

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
