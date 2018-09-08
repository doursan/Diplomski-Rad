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
  `vin` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `registration` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `production_year` smallint(4) DEFAULT NULL,
  `brand_model_id` int(10) DEFAULT NULL,
  `engine_id` int(10) DEFAULT NULL,
  `client_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`vin`),
  KEY `fk_engine` (`engine_id`),
  KEY `fk_model` (`brand_model_id`),
  KEY `fk_client` (`client_id`),
  CONSTRAINT `fk_client` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_engine` FOREIGN KEY (`engine_id`) REFERENCES `engine` (`id`),
  CONSTRAINT `fk_model` FOREIGN KEY (`brand_model_id`) REFERENCES `car_brand_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car` */

/*Table structure for table `car_brand` */

DROP TABLE IF EXISTS `car_brand`;

CREATE TABLE `car_brand` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `country` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car_brand` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car_brand_model` */

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `engine` */

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
  `TYPE` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `naziv` (`naziv`,`pib`,`maticni`,`jmbg`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`naziv`,`pib`,`maticni`,`ime`,`prezime`,`jmbg`,`TYPE`) values (0,'marko','marko','marko@alfa.com','amag','19382719','12398471',NULL,NULL,NULL,'S'),(7,'dusan','dusan','dusan.milenkovic191@gmail.com','dusan','dusan','dusan',NULL,NULL,NULL,'S'),(8,'milan','milan','milan@milan.com',NULL,NULL,NULL,'milan','milan','milan','C'),(9,'alex','alex','alex@alex.com','alex','alex','alex',NULL,NULL,NULL,'S'),(10,'milica','milica','milica@milica.com',NULL,NULL,NULL,'milica','milica','milica','C'),(11,'milija','milija','milija@milija.com',NULL,NULL,NULL,'milija','milija','milija','C');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
