CREATE DATABASE  IF NOT EXISTS `library_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `library_database`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: library_database
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books_details`
--

DROP TABLE IF EXISTS `books_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books_details` (
  `bookid` varchar(45) NOT NULL,
  `titles` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `mainclassification` varchar(45) DEFAULT NULL,
  `subclassification` varchar(45) DEFAULT NULL,
  `yearofpuclishing` varchar(45) DEFAULT NULL,
  `lastprintedyear` varchar(45) DEFAULT NULL,
  `isbnno` varchar(45) DEFAULT NULL,
  `noofpages` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookid`),
  KEY `fk_mainclass_idx` (`mainclassification`),
  KEY `fk_subclass_idx` (`subclassification`),
  CONSTRAINT `fk_mainclassId` FOREIGN KEY (`mainclassification`) REFERENCES `main_class` (`m_c_id`),
  CONSTRAINT `fk_sub` FOREIGN KEY (`subclassification`) REFERENCES `sub_class` (`s_c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_details`
--

LOCK TABLES `books_details` WRITE;
/*!40000 ALTER TABLE `books_details` DISABLE KEYS */;
INSERT INTO `books_details` VALUES ('001','TestTitle','TestAuthor','M006','S010','1999','2000','1234','987'),('002','mountain','rock','M006','S010','1995','2018','6000','500'),('0023','cupid','moral','M003','S005','1596','1980','456','1000'),('0024','q','dicaprio','M002','S003','1950','qqqq','qqqqq','12200'),('003','motta','laaboor','M004','S006','1658','2354','qqqqq','12200'),('004','abc','abc','M006','S008','2016','2018','testisbn','4000'),('005','cupid','christopher nolon','M004','S006','1950','1980','aaaaaaa','123'),('00500','moral','ww','M002','S004','12/56/464','1565','w','123'),('007','moral','dicaprio','M005','S007','1950','1980','456','1000'),('0070','q','qq','M002','S004','1596','1980','qqqqq','12200');
/*!40000 ALTER TABLE `books_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-25 17:14:00
