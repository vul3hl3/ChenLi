-- MySQL dump 10.13  Distrib 5.6.25, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: DemoDB
-- ------------------------------------------------------
-- Server version	5.6.25-0ubuntu0.15.04.1

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
-- Table structure for table `Activities`
--

DROP TABLE IF EXISTS `Activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activities` (
  `name` varchar(100) NOT NULL,
  `title` varchar(50) NOT NULL,
  `duration` varchar(100) NOT NULL,
  `task` varchar(1000) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activities`
--

LOCK TABLES `Activities` WRITE;
/*!40000 ALTER TABLE `Activities` DISABLE KEYS */;
INSERT INTO `Activities` VALUES ('O’camp','Coordinator','2011/08/27~2011/08/28','Coordinate, Distribute Works','2015-08-12 14:13:00');
/*!40000 ALTER TABLE `Activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Corp`
--

DROP TABLE IF EXISTS `Corp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Corp` (
  `sname` varchar(20) NOT NULL,
  `dname` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Corp`
--

LOCK TABLES `Corp` WRITE;
/*!40000 ALTER TABLE `Corp` DISABLE KEYS */;
INSERT INTO `Corp` VALUES ('SYSCOM','SYSCOM GROUP','2-7F No. 115 Emei Street, Wanhua District,Taipei City 108, Taiwan(R.O.C.)','886-2-21916066','886-2-23887171','info@syscom.com.tw','2015-08-11 04:07:44');
/*!40000 ALTER TABLE `Corp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Education`
--

DROP TABLE IF EXISTS `Education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Education` (
  `name` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL DEFAULT '',
  `degree` varchar(20) NOT NULL,
  `duration` varchar(50) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Education`
--

LOCK TABLES `Education` WRITE;
/*!40000 ALTER TABLE `Education` DISABLE KEYS */;
INSERT INTO `Education` VALUES ('Sun Yan-Sen University','Information Management','Master','Sept. 2010 - June 2012','2015-08-12 08:13:08'),('Yuan Ze University','Information Management  ','Bachelor','Sept. 2006 - June 2010','2015-08-12 08:13:33');
/*!40000 ALTER TABLE `Education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profile`
--

DROP TABLE IF EXISTS `Profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profile` (
  `id` varchar(20) NOT NULL,
  `chtname` varchar(20) NOT NULL,
  `engname` varchar(50) NOT NULL,
  `gender` char(1) NOT NULL,
  `cell` varchar(50) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `homeaddress` varchar(100) NOT NULL,
  `bilingaddress` varchar(100) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profile`
--

LOCK TABLES `Profile` WRITE;
/*!40000 ALTER TABLE `Profile` DISABLE KEYS */;
INSERT INTO `Profile` VALUES ('M122311629','Chen Li-Zen','Charlie','M','0972366383','1988/07/28','domybest17@gmail.com','No.96, Zucih Rd., Nantou City, Nantou County 54061, Taiwan (R.O.C.)','No.2, Ln. 94, Sec. 1, Kaifong St., Jhongjheng Dist., Taipei City 10042, Taiwan (R.O.C.)','2015-08-11 14:06:24');
/*!40000 ALTER TABLE `Profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Thesis`
--

DROP TABLE IF EXISTS `Thesis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Thesis` (
  `name` varchar(100) NOT NULL,
  `conference` varchar(100) DEFAULT NULL,
  `brief` varchar(2000) NOT NULL,
  `link` varchar(1000) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Thesis`
--

LOCK TABLES `Thesis` WRITE;
/*!40000 ALTER TABLE `Thesis` DISABLE KEYS */;
INSERT INTO `Thesis` VALUES ('Personalized Document Recommendation by Latent Dirichlet Allocation','INFORMS conference in Beijing in 2012','Accompanying with the rapid growth of Internet, people around the world can easily distribute, browse, and share as much information as possible through the Internet. The enormous amount of information, however, causes the information overload problem that is beyond users’ limited information processing ability. Therefore, recommender systems arise to help users to look for useful information when they cannot describe the requirements precisely. The filtering techniques in recommender systems can be categorized into content-based filtering (CBF) and collaborative filtering (CF). Although CF is shown to be superior over CBF in literature, personalized document recommendation relies more on CBF simply because of its text content in nature. Nevertheless, document recommendation task provides a good chance to integrate both techniques into a hybrid one, and enhance the overall recommendation performance. The objective of this research is thus to propose a hybrid filtering approach for personalized document recommendation. Particularly, latent Dirichlet allocation to uncover latent semantic structure in documents is incorporated to help users to either obtain robust document similarity in CF, or explore user profiles in CBF. Two experiments are conducted accordingly. The results show that our proposed approach outperforms other counterparts on the recommendation performance, which justifies the feasibility of our proposed approach in real applications.','https://ndltd.ncl.edu.tw/cgi-bin/gs32/gsweb.cgi/ccd=S4FC5I/record?r1=3&h1=0','2015-08-12 07:48:44');
/*!40000 ALTER TABLE `Thesis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Workexp`
--

DROP TABLE IF EXISTS `Workexp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Workexp` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `corp` varchar(50) NOT NULL DEFAULT '',
  `title` varchar(20) NOT NULL,
  `duration` varchar(50) NOT NULL,
  `task` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Workexp`
--

LOCK TABLES `Workexp` WRITE;
/*!40000 ALTER TABLE `Workexp` DISABLE KEYS */;
INSERT INTO `Workexp` VALUES (1,'SYSCOM','Soft Engineer','2012/09~2015/07','Project design development testing and maintenance~Project Version Control~Online issue immediate processing~Verify needs and architecture with the customers~Training recruit'),(2,'HealthInsurance Gov.','Soft Engineer','2009/02~2010/02','Project design development testing and maintenance~Online issue immediate processing');
/*!40000 ALTER TABLE `Workexp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-12 22:42:23
