-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: ZEH
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collection` (
  `Col_Num` int(11) NOT NULL AUTO_INCREMENT,
  `Col_Monthly` double NOT NULL,
  `Col_Date` varchar(25) NOT NULL,
  `Stall_Num` int(11) NOT NULL,
  `Emp_IDNum` int(11) NOT NULL,
  `Total_Arrears` double NOT NULL DEFAULT '0',
  `UnCollect` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`Col_Num`),
  KEY `Stall_Num` (`Stall_Num`),
  KEY `Emp_IDNum` (`Emp_IDNum`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`Stall_Num`) REFERENCES `stall` (`Stall_Num`),
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`Emp_IDNum`) REFERENCES `employee` (`Emp_IDNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

LOCK TABLES `collection` WRITE;
/*!40000 ALTER TABLE `collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `Cus_Num` int(11) NOT NULL DEFAULT '0',
  `Cus_FName` varchar(25) NOT NULL,
  `Cus_MidName` varchar(25) NOT NULL,
  `Cus_LName` varchar(25) NOT NULL,
  `Cus_Address` varchar(25) NOT NULL,
  `Cus_ContactNum` varchar(15) NOT NULL DEFAULT '0',
  `Cus_Status` varchar(20) NOT NULL DEFAULT 'Active',
  `Cus_Image` blob NOT NULL,
  `Cus_Pay_Status` varchar(45) NOT NULL DEFAULT 'PAID',
  `Cus_Path` varchar(45) NOT NULL DEFAULT '',
  `Cus_Arrears` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`Cus_Num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Emp_IDNum` int(11) NOT NULL DEFAULT '0',
  `Emp_Account` varchar(25) NOT NULL,
  `Emp_Password` varchar(25) NOT NULL,
  `Emp_FName` varchar(25) NOT NULL,
  `Emp_MidName` varchar(25) NOT NULL,
  `Emp_LName` varchar(25) NOT NULL,
  `Emp_Type` varchar(25) NOT NULL,
  `Emp_Status` varchar(20) NOT NULL DEFAULT 'Active',
  PRIMARY KEY (`Emp_IDNum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1111,'admin','admin','Neil','Gutual','Ragadio','Manager','Active'),(1112,'guest','guest','wew','Gaid','Langtad','Cashier','Active');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map`
--

DROP TABLE IF EXISTS `map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `map` (
  `Map_Num` int(11) NOT NULL AUTO_INCREMENT,
  `Map_Image` longblob NOT NULL,
  `Date_Update` varchar(25) NOT NULL,
  PRIMARY KEY (`Map_Num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map`
--

LOCK TABLES `map` WRITE;
/*!40000 ALTER TABLE `map` DISABLE KEYS */;
/*!40000 ALTER TABLE `map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section` (
  `Section_Num` int(11) NOT NULL DEFAULT '0',
  `Section_Type` varchar(25) NOT NULL,
  `Section_Description` varchar(25) NOT NULL,
  PRIMARY KEY (`Section_Num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stall`
--

DROP TABLE IF EXISTS `stall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stall` (
  `Stall_Num` int(11) NOT NULL DEFAULT '0',
  `Stall_Name` varchar(25) NOT NULL DEFAULT '',
  `Stall_Status` varchar(25) NOT NULL DEFAULT '',
  `Section_Num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Stall_Num`),
  KEY `Section_Num` (`Section_Num`),
  CONSTRAINT `stall_ibfk_1` FOREIGN KEY (`Section_Num`) REFERENCES `section` (`Section_Num`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stall`
--

LOCK TABLES `stall` WRITE;
/*!40000 ALTER TABLE `stall` DISABLE KEYS */;
/*!40000 ALTER TABLE `stall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stall_rate_history`
--

DROP TABLE IF EXISTS `stall_rate_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stall_rate_history` (
  `SRH_Num` int(11) NOT NULL AUTO_INCREMENT,
  `SRH_Price` double NOT NULL,
  `SRH_Date_of_Price_Change` varchar(25) NOT NULL,
  `Stall_Num` int(11) NOT NULL,
  PRIMARY KEY (`SRH_Num`),
  KEY `Stall_Num` (`Stall_Num`),
  CONSTRAINT `stall_rate_history_ibfk_1` FOREIGN KEY (`Stall_Num`) REFERENCES `stall` (`Stall_Num`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stall_rate_history`
--

LOCK TABLES `stall_rate_history` WRITE;
/*!40000 ALTER TABLE `stall_rate_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `stall_rate_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stall_rent_history`
--

DROP TABLE IF EXISTS `stall_rent_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stall_rent_history` (
  `STH_Num` int(11) NOT NULL AUTO_INCREMENT,
  `STH_Date_Of_Rent` varchar(25) NOT NULL,
  `Stall_Num` int(11) NOT NULL,
  `Cus_Num` int(11) NOT NULL,
  `STH_DueDate` varchar(45) NOT NULL DEFAULT '',
  `STH_Extension` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`STH_Num`),
  KEY `Stall_Num` (`Stall_Num`),
  KEY `Cus_Num` (`Cus_Num`),
  CONSTRAINT `stall_rent_history_ibfk_1` FOREIGN KEY (`Stall_Num`) REFERENCES `stall` (`Stall_Num`),
  CONSTRAINT `stall_rent_history_ibfk_2` FOREIGN KEY (`Cus_Num`) REFERENCES `customer` (`Cus_Num`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stall_rent_history`
--

LOCK TABLES `stall_rent_history` WRITE;
/*!40000 ALTER TABLE `stall_rent_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `stall_rent_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-07 21:29:29
