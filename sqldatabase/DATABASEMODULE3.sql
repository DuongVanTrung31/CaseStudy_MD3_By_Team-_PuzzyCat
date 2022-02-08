-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `bill`
--
CREATE DATABASE SHOP;
USE SHOP;
DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `USER_ID` int NOT NULL,
  `CREATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `DELIVERY` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `STATUS` varchar(100) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `PHONE` varchar(50) NOT NULL,
  `STAFF_ID` int NOT NULL,
  `TOTAL` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK_STAFFID` (`STAFF_ID`),
  KEY `FK_USERID` (`USER_ID`),
  CONSTRAINT `FK_STAFFID` FOREIGN KEY (`STAFF_ID`) REFERENCES `users` (`ID`),
  CONSTRAINT `FK_USERID` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_detail` (
  `BILL_ID` int NOT NULL,
  `PRODUCT_ID` int NOT NULL,
  `TOTAL` double NOT NULL,
  `QUANTITY` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`BILL_ID`,`PRODUCT_ID`),
  KEY `FK_PRODUCTID` (`PRODUCT_ID`),
  CONSTRAINT `FK_BILLID` FOREIGN KEY (`BILL_ID`) REFERENCES `bill` (`ID`),
  CONSTRAINT `FK_PRODUCTID` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Apple'),(2,'SamSung'),(3,'LG'),(4,'Xiaomi'),(5,'Oppo'),(6,'Asus'),(7,'Lenovo'),(8,'Dell');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Laptop'),(2,'Smart Phone'),(3,'Tablet');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SERIAL` varchar(100) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `CATEGORY_ID` int NOT NULL,
  `BRAND_ID` int NOT NULL,
  `PRICE` double NOT NULL DEFAULT '0',
  `QUANTITY` int NOT NULL DEFAULT '0',
  `DESCRIPTION` varchar(255) DEFAULT '',
  `IMAGE` varchar(255) DEFAULT NULL,
  `CREATE` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `STATUS` enum('ACTIVE','BLOCKED') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `P_SERIAL` (`SERIAL`),
  KEY `FK_BRAND` (`BRAND_ID`),
  KEY `FK_CATEGORY` (`CATEGORY_ID`),
  CONSTRAINT `FK_BRAND` FOREIGN KEY (`BRAND_ID`) REFERENCES `brand` (`ID`),
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'SM1','Iphone 13 Promax',2,1,32190,10,'Màn hình: OLED6.7\"Super Retina XDR, RAM: 6GB, Chip: Apple A15 Bionic','https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-gold-1-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(2,'SM2','Xiaomi 11T Pro 5G',2,4,13990,10,'Màn hình: AMOLED6.67\"Full HD+, RAM: 8GB, Chip: Snapdragon 888','https://cdn.tgdd.vn/Products/Images/42/262566/xiaomi-11t-pro-5g-8gb-thumb-600x600.jpeg','2021-11-30 10:00:00','ACTIVE'),(3,'SM3','Oppo Find X3 Pro 5G ',2,5,19490,10,'Màn hình: AMOLED6.7\"Quad HD+ (2K+), RAM: 12GB, Chip: Snapdragon 888','https://cdn.tgdd.vn/Products/Images/42/232190/oppo-find-x3-pro-black-001-1-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(4,'SM4','Iphone SE',2,1,11990,10,'Màn hình: IPS LCD4.7\"Retina HD,  RAM: 3GB, Chip: Apple A13 Bionic','https://cdn.tgdd.vn/Products/Images/42/230410/iphone-se-2020-trang-600x600-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(5,'SM5','SamSung Galaxy Fold',2,2,41990,10,'Màn hình: Dynamic AMOLED 2XChính 7.6\" & Phụ 6.2\"Full HD+,  RAM: 12GB,  Chip: Snapdragon 888 ','https://cdn.tgdd.vn/Products/Images/42/226935/samsung-galaxy-z-fold-3-silver-1-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(6,'LT1','Apple MacBook Pro 16 M1 Pro 2021',1,1,64990,10,'Màn hình: 16.2 inchLiquid Retina XDR display (3456 x 2234), RAM: 16GB, Chip: Apple M1 Pro200GB/s memory bandwidth','https://cdn.tgdd.vn/Products/Images/44/253636/apple-macbook-pro-16-m1-pro-2021-10-core-cpu-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(7,'LT2','Laptop Lenovo ThinkBook 14s G2 ITL i5',1,7,23690,10,'Màn hình: 14\"Full HD (1920 x 1080), RAM: 8 GBDDR4 (On board)4266 MHz, Chip: i51135G72.4GHz','https://cdn.tgdd.vn/Products/Images/44/235393/lenovo-thinkbook-14s-g2-itl-i5-20va000nvn-600x600-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(8,'LT3','Laptop Asus ZenBook UX371EA',1,6,41490,10,'Màn hình: 13.3\"4K/UHD (3840 x 2160), OLED, RAM: 16GB, Chip: i71165G72.8GHz','https://cdn.tgdd.vn/Products/Images/44/264547/asus-zenbook-ux363ea-i7-1165g7-16gb-512gb-131221-115725-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(9,'LT4','Laptop Dell Latitude 3520',1,8,30990,10,'Màn hình: 15.6\"Full HD (1920 x 1080), RAM: 8GB, Chip: i71165G72.8GHz','https://cdn.tgdd.vn/Products/Images/44/252808/dell-latitude-3520-i7-70261780-091221-022033-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(10,'LT5','Laptop LG Gram 17 2021',1,3,47390,10,'Màn hình: 17\"WQXGA (2560 x 1600), RAM: 16GB, Chip:  i7 1165G7 2.8GHz','https://cdn.tgdd.vn/Products/Images/44/238135/TimerThumb/lg-gram-17-i7-17z90pgah76a5.jpg','2021-11-30 10:00:00','ACTIVE'),(11,'TB1','Máy tính bảng iPad Pro M1',3,1,36490,10,'Màn hình: 12.9\"Liquid Retina XDR mini-LED LCD, RAM: 8GB, Chip: Apple M1','https://cdn.tgdd.vn/Products/Images/522/238649/ipad-pro-2021-129-inch-gray-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(12,'TB2','Máy tính bảng Samsung Galaxy Tab S7',3,2,18990,10,'Màn hình: 11\"LTPS IPS LCD, RAM: 6GB, Chip: Snapdragon 865+','https://cdn.tgdd.vn/Products/Images/522/225031/samsung-galaxy-tab-s7-thumb-xanh-600x600-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(13,'TB3','Máy tính bảng Lenovo Tab P11 Plus',3,7,8190,10,'Màn hình: 11\"IPS LCD, RAM: 4GB, Chip: MediaTek Helio G90T','https://cdn.tgdd.vn/Products/Images/522/244684/lenovo-tab-p11-plus-2-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(14,'TB4','Máy tính bảng Xiaomi Pad 5',3,4,10490,10,'Màn hình: 11\"IPS LCD, RAM: 6GB, Chip: Snapdragon 860 ','https://cdn.tgdd.vn/Products/Images/522/250934/xiaomi-pad-5-grey-600x600.jpg','2021-11-30 10:00:00','ACTIVE'),(15,'TB5','Máy tính bảng iPad Air 4',3,1,21990,10,'Màn hình: 10.9\"Liquid Retina, RAM: 4GB, Chip: Apple A14 Bionic','https://cdn.tgdd.vn/Products/Images/522/228897/ipad-4-cellular-den-new-600x600-600x600.jpg','2021-11-30 10:00:00','ACTIVE');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` int NOT NULL,
  `RATE` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKPRODUCTID` (`PRODUCT_ID`),
  CONSTRAINT `FKPRODUCTID` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PRODUCT_ID` int DEFAULT NULL,
  `USER_ID` int DEFAULT NULL,
  `COMMENT` text,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCT_ID` (`PRODUCT_ID`),
  KEY `FK_USER_ID` (`USER_ID`),
  CONSTRAINT `FK_PRODUCT_ID` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`),
  CONSTRAINT `FK_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ACCOUNT` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `FIRSTNAME` varchar(100) NOT NULL,
  `LASTNAME` varchar(100) NOT NULL,
  `ADDRESS` varchar(255) NOT NULL,
  `PHONE` varchar(20) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `BIRTHDAY` date NOT NULL,
  `ROLE` enum('ADMIN','USER','STAFF') DEFAULT 'USER',
  `STATUS` enum('ACTIVE','BLOCKED') DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `U_ACCOUNT` (`ACCOUNT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-08 10:48:32
