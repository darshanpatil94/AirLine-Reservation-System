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
-- Table structure for table `N3Flight`
--

DROP TABLE IF EXISTS `N3Flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `N3Flight` (
  `SeatNumber` varchar(45) NOT NULL,
  `Type` varchar(5) DEFAULT NULL,
  `Availability` varchar(5) DEFAULT NULL,
  `AllocatedUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SeatNumber`),
  UNIQUE KEY `SeatNumber_UNIQUE` (`SeatNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `N3Flight`
--

LOCK TABLES `N3Flight` WRITE;
/*!40000 ALTER TABLE `N3Flight` DISABLE KEYS */;
INSERT INTO `N3Flight` VALUES ('A1','F','O',NULL),('A2','F','O',NULL),('A3','F','O',NULL),('A4','F','O',''),('B1','F','O',NULL),('B2','F','O',NULL),('B3','F','O',NULL),('B4','F','O',NULL),('C1','F','O',NULL),('C2','F','O',NULL),('C3','F','X','darshan'),('C4','F','X','darshan'),('D1','E','X','darshan'),('D2','E','X','darshan'),('D3','E','O',NULL),('D4','E','O',NULL),('E1','E','O',NULL),('E2','E','O',NULL),('E3','E','O',NULL),('E4','E','O',NULL),('F1','E','O',NULL),('F2','E','O',NULL),('F3','E','O',NULL),('F4','E','O',NULL);
/*!40000 ALTER TABLE `N3Flight` ENABLE KEYS */;
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
