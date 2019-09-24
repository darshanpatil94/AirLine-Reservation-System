-- MySQL dump 10.13  Distrib 8.0.17, for macos10.14 (x86_64)
--
-- Host: localhost    Database: test_db
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `FlightsDetails`
--

DROP TABLE IF EXISTS `FlightsDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FlightsDetails` (
  `FlightNumber` varchar(45) NOT NULL,
  `DeptAirport` varchar(45) DEFAULT NULL,
  `ArrAirport` varchar(45) DEFAULT NULL,
  `DeptTime` varchar(45) DEFAULT NULL,
  `ArrTime` varchar(45) DEFAULT NULL,
  `Price(E)` varchar(45) DEFAULT NULL,
  `Price(F)` varchar(45) DEFAULT NULL,
  `AvSeats` varchar(45) DEFAULT NULL,
  `Date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`FlightNumber`),
  UNIQUE KEY `PlaneNumber_UNIQUE` (`FlightNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FlightsDetails`
--

LOCK TABLES `FlightsDetails` WRITE;
/*!40000 ALTER TABLE `FlightsDetails` DISABLE KEYS */;
INSERT INTO `FlightsDetails` VALUES ('N1','LAX','JFK','2:00 PM','10:40 PM','150','300','20','11/11/2019'),('N2','LAX','LAS','6:00 AM','7:15 AM','60','110','20','11/11/2019'),('N3','LAX','SFO','9:45 AM','11:00 AM','100','150','20','11/11/2019'),('N4','LAX','BOS','7:00AM','11:50AM','120','230','40','11/12/2019');
/*!40000 ALTER TABLE `FlightsDetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-05 13:50:57
