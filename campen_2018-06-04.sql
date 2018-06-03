# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: campen
# Generation Time: 2018-06-03 17:09:48 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table promotion_applied
# ------------------------------------------------------------

DROP TABLE IF EXISTS `promotion_applied`;

CREATE TABLE `promotion_applied` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `promotion_id` bigint(11) NOT NULL,
  `num_applied` int(11) NOT NULL DEFAULT '0',
  `tmn_id` varchar(100) NOT NULL DEFAULT '',
  `mobile_no` varchar(100) NOT NULL DEFAULT '',
  `thai_id` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `promotion_id` (`promotion_id`,`tmn_id`),
  UNIQUE KEY `promotion_id_2` (`promotion_id`,`mobile_no`),
  UNIQUE KEY `promotion_id_3` (`promotion_id`,`thai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `promotion_applied` WRITE;
/*!40000 ALTER TABLE `promotion_applied` DISABLE KEYS */;

INSERT INTO `promotion_applied` (`id`, `promotion_id`, `num_applied`, `tmn_id`, `mobile_no`, `thai_id`)
VALUES
	(1,1,0,'tmn.1','0891000000','1234567890123'),
	(2,1,7,'tmn.2','mobile2','thai2zz'),
	(32,2,72,'tmn.1','mobile3','thai1'),
	(54,2,72,'tmn.1-1','mobile1','thai2'),
	(96,3,1,'tmn.9','mobile9','thai9'),
	(131,2,3,'tmn.7','mobile7','thai7'),
	(184,4,10,'tmn.2','mobile2','thai2'),
	(185,4,10,'tmn.1','mobile1','thai1'),
	(189,5,2,'tmn.1','mobile1','thai1');

/*!40000 ALTER TABLE `promotion_applied` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
