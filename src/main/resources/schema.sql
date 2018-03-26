DROP DATABASE `db_health`;
CREATE DATABASE  IF NOT EXISTS `db_health` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_health`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db_health
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `daily_statistics`
--

DROP TABLE IF EXISTS `daily_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dayid` bigint(20) NOT NULL,
  `totalcalories` double NOT NULL,
  `userid` bigint(20) NOT NULL,
  `steps` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_statistics`
--

LOCK TABLES `daily_statistics` WRITE;
/*!40000 ALTER TABLE `daily_statistics` DISABLE KEYS */;
INSERT INTO `daily_statistics` VALUES (92,48,639600,11,0),(93,40,0,11,0),(94,49,0,11,0),(95,50,0,11,1200),(96,53,10980,11,8890),(97,54,670777,11,720),(98,55,885888.5,11,500),(99,56,518400,11,1220),(100,57,1100800,11,100),(101,58,152400,11,120),(102,59,209040,11,1000),(103,60,113400,11,1330),(105,62,-100,11,2110),(106,63,-100,11,200),(113,65,523600,11,150),(114,69,100,11,159),(115,68,100,11,160),(116,67,100,11,161),(117,70,0,11,1229),(123,77,0,11,2953),(124,77,-100,3,2962),(126,79,200,11,1005),(127,80,200,11,1055),(128,81,200,11,1065),(129,82,200,11,1167),(130,78,0,11,500),(131,83,0,11,0),(132,84,-100,11,15),(133,84,0,3,593),(135,86,200,11,500),(136,87,200,11,1500),(137,88,200,11,2200),(138,89,200,11,600),(139,90,152400,11,5234),(140,90,0,18,0),(141,91,1450865.5,11,150),(142,91,0,18,0),(143,91,0,19,0),(144,92,0,11,0),(145,92,0,18,0),(146,93,0,11,0),(147,94,-100,11,2125),(149,96,0,11,30),(150,97,183100,11,1500),(151,98,487200,11,1230),(152,99,0,11,998),(153,100,0,11,2113),(154,101,152400,11,973),(155,105,37536,11,18);
/*!40000 ALTER TABLE `daily_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day`
--

DROP TABLE IF EXISTS `day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 KEY_BLOCK_SIZE=8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day`
--

LOCK TABLES `day` WRITE;
/*!40000 ALTER TABLE `day` DISABLE KEYS */;
INSERT INTO `day` VALUES (2,'2016-09-08'),(3,'2015-12-15'),(4,'2017-07-04'),(5,'2017-07-24'),(6,'2017-04-18'),(7,'2017-04-08'),(8,'2017-11-23'),(9,'2017-11-24'),(10,'2017-11-26'),(11,'2017-11-27'),(12,'2017-11-28'),(18,'2017-11-29'),(19,'2017-12-03'),(20,'2017-10-12'),(21,'2017-12-01'),(22,'2017-03-04'),(23,'2017-11-30'),(24,'2017-12-07'),(25,'2017-12-08'),(26,'2017-12-13'),(27,'2017-12-15'),(28,'2017-12-17'),(29,'2017-12-18'),(30,'2017-12-19'),(31,'2017-12-20'),(32,'2017-12-27'),(33,'2017-12-28'),(34,'2018-01-08'),(36,'2018-02-09'),(37,'2018-01-10'),(38,'2018-02-10'),(39,'2018-01-13'),(41,'2018-01-14'),(42,'2018-01-15'),(43,'2018-01-16'),(44,'2018-01-17'),(45,'2018-01-25'),(46,'2018-01-26'),(47,'2018-02-11'),(48,'2018-02-12'),(53,'2018-02-13'),(54,'2018-02-15'),(55,'2018-02-17'),(56,'2018-02-19'),(57,'2018-02-18'),(58,'2018-02-20'),(59,'2018-02-21'),(60,'2018-02-22'),(62,'2018-02-23'),(63,'2018-02-25'),(65,'2018-02-28'),(67,'2018-02-27'),(68,'2018-02-26'),(69,'2018-02-24'),(70,'2018-03-01'),(77,'2018-03-04'),(78,'2018-03-07'),(79,'2018-03-02'),(80,'2018-03-03'),(81,'2018-03-05'),(82,'2018-03-06'),(83,'2018-03-08'),(84,'2018-03-09'),(86,'2018-03-10'),(87,'2018-03-11'),(88,'2018-03-12'),(89,'2018-03-13'),(90,'2018-03-14'),(91,'2018-03-15'),(92,'2018-03-16'),(93,'2018-03-18'),(94,'2018-03-19'),(96,'2018-03-20'),(97,'2018-03-21'),(98,'2018-03-22'),(99,'2018-03-23'),(100,'2018-03-24'),(101,'2018-03-25'),(105,'2018-03-26');
/*!40000 ALTER TABLE `day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `day_food`
--

DROP TABLE IF EXISTS `day_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `day_food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dayid` bigint(20) NOT NULL,
  `foodid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=185 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `day_food`
--

LOCK TABLES `day_food` WRITE;
/*!40000 ALTER TABLE `day_food` DISABLE KEYS */;
INSERT INTO `day_food` VALUES (27,41,3),(28,41,4),(29,41,9),(30,41,8),(31,41,5),(32,39,2),(35,41,1),(36,42,8),(37,42,5),(38,43,4),(39,43,2),(40,43,1),(41,43,6),(42,43,5),(43,44,10),(44,44,6),(45,44,8),(46,45,8),(47,45,5),(48,45,7),(49,45,2),(50,45,1),(51,45,10),(52,46,3),(53,46,2),(54,46,8),(55,46,6),(56,46,1),(57,46,10),(58,38,2),(59,38,4),(60,38,7),(61,47,13),(62,47,14),(63,47,15),(64,47,16),(65,47,17),(66,47,18),(67,47,19),(68,47,20),(69,47,21),(70,48,22),(71,48,23),(72,48,24),(73,48,25),(74,48,2),(75,48,8),(76,48,26),(77,53,2),(78,53,27),(79,53,7),(80,53,28),(81,54,7),(82,54,4),(83,54,8),(84,54,29),(85,55,17),(86,55,3),(87,55,8),(88,55,20),(89,56,8),(90,56,30),(91,56,31),(92,56,32),(93,56,16),(94,56,33),(95,56,25),(97,56,835),(98,56,836),(99,56,837),(100,56,838),(101,56,12),(102,56,2),(103,56,27),(104,56,839),(105,56,840),(106,56,10),(107,56,841),(108,56,842),(109,56,843),(110,56,844),(111,56,3),(112,57,2),(113,57,845),(114,58,2),(115,58,846),(116,58,8),(117,58,31),(118,58,10),(119,58,5),(120,58,847),(121,58,848),(122,58,849),(123,58,850),(124,58,851),(125,58,852),(126,58,853),(127,58,30),(128,58,854),(129,58,6),(130,58,3),(131,58,855),(132,58,856),(133,58,857),(134,58,858),(135,58,859),(136,58,7),(137,58,20),(138,58,860),(139,58,861),(140,58,862),(141,59,2),(142,59,8),(143,60,1),(144,61,7),(152,5,12),(153,65,6),(154,65,12),(155,65,5),(156,90,2),(157,90,863),(158,91,847),(159,91,8),(160,91,10),(161,91,864),(162,90,8),(163,53,6),(164,91,6),(165,91,865),(166,91,2),(167,92,8),(168,92,6),(169,92,5),(170,92,2),(171,92,866),(172,92,9),(173,92,867),(174,97,2),(175,97,6),(176,98,8),(177,98,5),(178,98,7),(179,101,2),(180,101,868),(181,105,33),(182,105,17),(183,105,34),(184,105,2);
/*!40000 ALTER TABLE `day_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `carbohydrates` double NOT NULL,
  `category` varchar(255) NOT NULL,
  `fats` double NOT NULL,
  `foodname` varchar(255) NOT NULL,
  `proteins` double NOT NULL,
  `picturestring` varchar(255) NOT NULL,
  `stars` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=872 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (2,123,'Fruits',20,'Melon',213,'melon',5,'https://draxe.com/cantaloupe-nutrition/'),(3,0,'Dairy products',8.9,'Cheese',6,'cheese',3,'https://www.healthline.com/nutrition/foods/cheese'),(4,25,'Sweets',11,'Chocolate',2,'chocolate',3,'https://www.healthline.com/nutrition/7-health-benefits-dark-chocolate'),(5,30,'Soups',8,'Vegetable-soup',15,'vegetablesoup',4,'https://www.livestrong.com/article/405481-is-vegetable-soup-healthy/'),(6,11.8,'Fruits',0.1,'Oranges',0.9,'oranges',5,'https://www.healthline.com/nutrition/foods/oranges'),(7,22.8,'Fruits',0.3,'Banana',1.1,'banana',5,'https://www.healthline.com/nutrition/11-proven-benefits-of-bananas'),(8,10.7,'Fruits',0.6,'Strawberries',0.9,'strawberries',3,'https://www.healthline.com/nutrition/foods/strawberries'),(9,1.9,'Drink',0,'Carrot-juice',0.3,'carrotjuice',5,'https://www.healthline.com/health/carrot-juice-benefits'),(10,22.78,'Grains',0.89,'Brown-rice',2.56,'brownrice',5,'https://www.livescience.com/50461-brown-rice-health-benefits-nutrition-facts.html'),(11,6.6,'Vegetables',0.4,'Broccoli',2.8,'broccoli',5,'https://www.healthline.com/nutrition/foods/broccoli#section1'),(12,10,'Fruits',30,'Apple',20,'healthyfood',4,'https://www.healthyfood.co.nz'),(13,10,'Fruits',40,'Pear',20,'healthyfood',3,'https://www.healthyfood.co.nz'),(14,100,'Fish products',50,'Backed fish',12,'healthyfood',2,'https://www.healthyfood.co.nz'),(15,15,'Fish products',10,'Fish',21,'healthyfood',1,'https://www.healthyfood.co.nz'),(16,12,'Drink',5,'Apple-juice',11,'healthyfood',1,'https://www.healthyfood.co.nz'),(17,15,'Fruits',26.6,'Avocado',3.4,'avocado',4,'https://www.livestrong.com/article/348060-the-carb-protein-values-of-avocados/'),(18,10,'category',0,'Sushi',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(19,0,'category',0,'Nectar juice',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(20,10,'Seeds',30,'Chia seeds',2,'healthyfood',3,'https://www.healthyfood.co.nz'),(21,1,'Water',3,'Water',2,'healthyfood',1,'https://www.healthyfood.co.nz'),(22,10,'Fruits',30,'Cherry',20,'healthyfood',2,'https://www.healthyfood.co.nz'),(23,10,'Fruits',20,'Cherry2',20,'healthyfood',3,'https://www.healthyfood.co.nz'),(24,10,'Paste',11,'Spaghetti',11,'healthyfood',1,'https://www.healthyfood.co.nz'),(26,0,'category',0,'Cherry3',0,'healthyfood',4,'https://www.healthyfood.co.nz'),(27,5,'Fruits',10,'BlueBerries',2,'healthyfood',2,'https://www.healthyfood.co.nz'),(28,2,'category',0,'Water2',1,'healthyfood',1,'https://www.healthyfood.co.nz'),(29,12,'Soup',40,'Chicken Soup',9,'healthyfood',2,'https://www.healthyfood.co.nz'),(30,3,'category',1,'Cat',2,'healthyfood',1,'https://www.healthyfood.co.nz'),(31,1,'Drink',12,'Milk',40,'healthyfood',3,'https://www.healthyfood.co.nz'),(32,3,'Drink',69,'milk2',8,'healthyfood',2,'https://www.healthyfood.co.nz'),(33,4.4,'Dessert',5.6,'Chia-Seeds-Pudding',3.4,'chiaseedspudding',5,'https://www.healthline.com/nutrition/foods/chia-seeds'),(34,59,'Breakfast',3,'Kiwi-Banana-Smoothie',11,'kiwibananasmoothie',4,'https://hurrythefoodup.com/spicy-kiwi-banana-breakfast-smoothie/'),(835,5,'Fruits',20,'Kiwi',8,'healthyfood',4,'https://www.healthyfood.co.nz'),(836,0,'Category',0,'kiwi2',0,'healthyfood',1,'https://www.healthyfood.co.nz'),(837,7,'Sweets',60,'Cookies ',9,'healthyfood',2,'https://www.healthyfood.co.nz'),(838,5,'Sweets',10,'White Chocolate',8,'healthyfood',2,'https://www.healthyfood.co.nz'),(839,0,'Category',0,'an',0,'healthyfood',4,'https://www.healthyfood.co.nz'),(840,0,'Category',0,'ll',0,'healthyfood',3,'https://www.healthyfood.co.nz'),(841,0,'Category',0,'cereale',0,'healthyfood',3,'https://www.healthyfood.co.nz'),(842,0,'Category',0,'pepene',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(843,0,'Category',0,'cheese1',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(844,20,'Fruits',10,'Green-apple',11,'healthyfood',3,'https://www.healthyfood.co.nz'),(845,10,'Fruits',10,'Apricots',10,'healthyfood',1,'https://www.healthyfood.co.nz'),(846,10,'category',10,'Plums',0,'healthyfood',3,'https://www.healthyfood.co.nz'),(847,2,'Soup',10,'Carrot soup',15,'healthyfood',2,'https://www.healthyfood.co.nz'),(848,10,'Fruits',10,'Cranberries',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(849,11,'Fruits',20,'Cranberries2',2,'healthyfood',4,'https://www.healthyfood.co.nz'),(850,0,'category',0,'Pumpkin',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(851,0,'category',0,'food',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(852,0,'category',0,'food2',0,'healthyfood',4,'https://www.healthyfood.co.nz'),(853,11,'Tea',10,'Lemon tea',11,'healthyfood',2,'https://www.healthyfood.co.nz'),(854,5,'Diary products',90,'cheese tom',88,'healthyfood',2,'https://www.healthyfood.co.nz'),(855,5,'Sweets',80,'Cookies2',8,'healthyfood',3,'https://www.healthyfood.co.nz'),(856,5,'Sweets',80,'Cookies23',8,'healthyfood',1,'https://www.healthyfood.co.nz'),(857,100,'Meal',90,'Meal',20,'healthyfood',1,'https://www.healthyfood.co.nz'),(858,9,'Fruits',60,'Mango',77,'healthyfood',1,'https://www.healthyfood.co.nz'),(859,30,'Sweets',40,'chocolate with oreo',65,'healthyfood',4,'https://www.healthyfood.co.nz'),(860,0,'category',0,'t',0,'healthyfood',1,'https://www.healthyfood.co.nz'),(861,6,'Fish',90,'h',80,'healthyfood',4,'https://www.healthyfood.co.nz'),(862,40,'Chicken',7,'Chicken ',10,'healthyfood',2,'https://www.healthyfood.co.nz'),(863,0,'',0,'saratele',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(864,10,'Fruits ',10,'GoodFood',5,'healthyfood',3,'https://www.healthyfood.co.nz'),(865,0,'',0,'alimentNou',0,'healthyfood',2,'https://www.healthyfood.co.nz'),(866,2,'category',50,'nou',3,'healthyfood',4,'https://www.healthyfood.co.nz'),(867,0,'',0,'al',0,'healthyfood',1,'https://www.healthyfood.co.nz'),(868,0,'category',0,'new',0,'healthyfood',3,'https://www.healthyfood.co.nz'),(871,4.7,'Yogurt',3.3,'Yogurt',3.5,'yogurt',5,'https://www.healthline.com/nutrition/foods/yogurt#section1');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `contactno` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(1) NOT NULL,
  `height` int(11) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `weight` int(11) NOT NULL,
  `stepsobjective` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,0,'aa','alala','Mihalcea','F',161,'Andreea','123','Andree',53,6000),(2,21,'123','ass','Popescu','M',187,'Mihai','mihnea123','Mihnea',70,6000),(3,20,'9i3i4i','heeei','Mihalcea','F',162,'Raluca','123','Ralu',53,6000),(4,0,' ',' ','Herciu','F',162,'Simona','usor','Sim',63,6000),(5,0,' ',' ','Florea','M',188,'Alex','123','Alex',77,6000),(6,20,'075766376','','tt','F',153,'tt','123','test',55,6000),(7,25,'0765899777','radu.m@yahoo.com','Luca','M',175,'Radu','123g','Radu',70,6000),(8,0,' ','ale.s@gmail.com','Danu','F',180,'Alexandra','ale','Alexandra',70,6000),(9,0,' ','andreea_mih97@yahoo.com','Mihalceq','F',161,'Andreea','123','Andreeq',53,6000),(10,0,' ','favius.paunescu@gmail.com','Paunescu','M',243,'Flavius','123','Flavius',82,6000),(11,21,'0765899755','andreea_mih97@yahoo.com','Mihalcea','F',162,'Andreea','1234','Andreea',88,5),(12,0,' ','deta.mih@yahoo.com','Mihalcea','F',161,'Deta','123','Mama',100,6000),(16,0,' ','andra@yahoo.com','Popescu','F',167,'Andra','123','Andra',60,6000),(17,0,' ','n@gmail.com','Mihalcea','F',168,'Andreea','ni','Nicolleta',53,6000),(18,27,'0765111111','anda@yahoo.com','Ionescu','F',67,'Anda','anda','Maria',172,2550),(19,0,' ','aa@yahoo.com','Mihalcea','F',163,'Andreea','12','AndreeaUser',53,6000),(20,0,' ','andreea@yahoo.com','A','F',170,'B','123','UserNou',60,6000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_diary`
--

DROP TABLE IF EXISTS `user_diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_diary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` double NOT NULL,
  `dayfood_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKepmrh7ag71j3aoahgpd79eqet` (`dayfood_id`),
  KEY `FKlok9fne8rjhtjjdkvyp09rqcp` (`user_id`),
  CONSTRAINT `FKepmrh7ag71j3aoahgpd79eqet` FOREIGN KEY (`dayfood_id`) REFERENCES `day_food` (`id`),
  CONSTRAINT `FKlok9fne8rjhtjjdkvyp09rqcp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=220 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_diary`
--

LOCK TABLES `user_diary` WRITE;
/*!40000 ALTER TABLE `user_diary` DISABLE KEYS */;
INSERT INTO `user_diary` VALUES (27,9922,28,17),(28,100,29,11),(29,300.5,30,11),(31,100,32,11),(34,100.25,31,17),(35,100,35,17),(36,507777,36,11),(37,67,37,11),(41,200,40,11),(43,200,41,11),(44,200,38,11),(45,300,39,11),(46,100,42,11),(47,100,43,11),(48,100,44,11),(49,100,45,11),(68,100,48,11),(69,10,52,11),(70,1755,53,11),(72,100,55,11),(74,200,57,11),(75,101.25,56,11),(76,100,58,11),(77,100,59,11),(78,100,60,11),(79,200,61,11),(80,400,62,11),(81,200,63,11),(82,200,64,11),(83,200,65,11),(84,200,66,11),(85,200,67,11),(86,202,68,11),(87,200,69,11),(88,500,70,11),(89,200,71,11),(90,200,72,11),(91,200,73,11),(92,200,74,11),(93,200,75,11),(94,200,76,11),(97,55,79,11),(131,1780,109,11),(132,100,110,11),(133,100,102,11),(134,100,111,11),(135,700,112,11),(136,200,113,11),(170,100,114,11),(171,100,141,11),(172,320,142,11),(173,100,143,11),(174,100,144,11),(183,100,152,11),(184,100,153,11),(185,100,154,11),(186,100,155,11),(189,100,156,11),(192,955.75,160,11),(193,200,161,11),(194,100,162,11),(195,101.25,163,11),(196,100.5,164,11),(197,100.5,165,11),(198,300,166,11),(207,100.5,173,11),(208,100,174,11),(209,100,175,11),(210,100,176,11),(211,100,177,11),(212,100,178,11),(214,100,180,11),(215,100,179,11),(216,460,181,11);
/*!40000 ALTER TABLE `user_diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weight_statistics`
--

DROP TABLE IF EXISTS `weight_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weight_statistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `current_weight` double NOT NULL,
  `userid` bigint(20) NOT NULL,
  `dayid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weight_statistics`
--

LOCK TABLES `weight_statistics` WRITE;
/*!40000 ALTER TABLE `weight_statistics` DISABLE KEYS */;
INSERT INTO `weight_statistics` VALUES (8,86,11,53),(9,334,11,53),(10,261,11,53),(11,356,11,53),(12,52,11,22),(13,69,11,53),(14,45,11,54),(15,30,11,54),(16,51,11,54),(17,57,11,54),(18,0,11,54),(19,52,11,22),(20,85,11,56),(21,98,11,90),(22,82,11,91),(23,55,11,91),(24,39,11,91),(25,132,11,91),(26,92,11,92),(27,197,11,92),(28,51,11,92),(29,71,11,94),(30,71,11,96),(31,71,11,97),(32,58,11,98),(33,88,11,105);
/*!40000 ALTER TABLE `weight_statistics` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-26 15:23:09
