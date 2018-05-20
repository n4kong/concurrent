# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.22)
# Database: campen
# Generation Time: 2018-05-20 12:13:46 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table PROMOTION_APPLIED
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PROMOTION_APPLIED`;

CREATE TABLE `PROMOTION_APPLIED` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `promotion_id` bigint(11) NOT NULL,
  `num_applied` int(11) NOT NULL DEFAULT '0',
  `tmn_id` varchar(100) NOT NULL DEFAULT '',
  `mobile_no` varchar(100) NOT NULL DEFAULT '',
  `thai_id` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

LOCK TABLES `PROMOTION_APPLIED` WRITE;
/*!40000 ALTER TABLE `PROMOTION_APPLIED` DISABLE KEYS */;

INSERT INTO `PROMOTION_APPLIED` (`id`, `promotion_id`, `num_applied`, `tmn_id`, `mobile_no`, `thai_id`)
VALUES
	(1,1,0,'tmn.1','0891000000','1234567890123'),
	(2,1,0,'tmn.2','mobile2','thai2'),
	(3,1,0,'tmn.2','mobile2.1','thai2.1');

/*!40000 ALTER TABLE `PROMOTION_APPLIED` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
