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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`naziv`,`pib`,`maticni`,`ime`,`prezime`,`jmbg`,`TYPE`) values (0,'marko','marko','marko@alfa.com','amag','19382719','12398471',NULL,NULL,NULL,'S'),(7,'dusan','dusan','dusan.milenkovic191@gmail.com','dusan','dusan','dusan',NULL,NULL,NULL,'S'),(8,'milan','milan','milan@milan.com',NULL,NULL,NULL,'milan','milan','milan','C');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
