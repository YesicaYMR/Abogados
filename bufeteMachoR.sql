CREATE DATABASE  IF NOT EXISTS `bufetemachor` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bufetemachor`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: bufetemachor
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `acciones`
--

DROP TABLE IF EXISTS `acciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acciones` (
  `cod_caso` varchar(5) NOT NULL,
  `cod_accion` varchar(3) NOT NULL,
  `fecha` varchar(10) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cod_caso`,`cod_accion`),
  CONSTRAINT `cod_caso` FOREIGN KEY (`cod_caso`) REFERENCES `casos` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acciones`
--

LOCK TABLES `acciones` WRITE;
/*!40000 ALTER TABLE `acciones` DISABLE KEYS */;
INSERT INTO `acciones` VALUES ('1','APE','27/05/2023','Apertura del caso'),('1','int','27/05/2023','intento de accion'),('10','APE','27/05/2023','Apertura del caso'),('10','nue','27/05/2023','intento final'),('11','APE','29/05/2023','Apertura del caso'),('12','APE','29/05/2023','Apertura del caso'),('2','APE','27/05/2023','Apertura del caso'),('2','CER','27/05/2023','Cierre del caso'),('3','APE','27/05/2023','Apertura del caso'),('4','APE','27/05/2023','Apertura del caso'),('4','CER','27/05/2023','Cierre del caso'),('5','APE','27/05/2023','Apertura del caso'),('5','CER','29/05/2023','Cierre del caso'),('6','APE','27/05/2023','Apertura del caso'),('6','CER','27/05/2023','Cierre del caso'),('6','int','27/05/2023','intento de acciones');
/*!40000 ALTER TABLE `acciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casos`
--

DROP TABLE IF EXISTS `casos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casos` (
  `codigo` varchar(5) NOT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `titulo` varchar(30) DEFAULT NULL,
  `descripcion` varchar(30) DEFAULT NULL,
  `situacion` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `dni_idx` (`dni`),
  CONSTRAINT `dni` FOREIGN KEY (`dni`) REFERENCES `personal` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casos`
--

LOCK TABLES `casos` WRITE;
/*!40000 ALTER TABLE `casos` DISABLE KEYS */;
INSERT INTO `casos` VALUES ('1','1','prueba 1','prueba funcionamiento','a'),('10','1','prueba final','prueba de funcionamiento final','a'),('11','1','prueba','prueba','a'),('12','1','prueba','1','a'),('2','1','prueba 2','prueba 2 de funcionamiento','c'),('3','2','prueba 3','prueba 3 de funcionamiento','a'),('4','3','prueba 4','prueba 4 de funcionamiento','c'),('5','4','prueba 5','prueba 5 de funcionamiento','c'),('6','1','prueba 6','prueba 6 de funcionamiento','c');
/*!40000 ALTER TABLE `casos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `login` varchar(40) NOT NULL,
  `contra` varchar(50) DEFAULT NULL,
  `perfil` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES ('1','Ana Alvarez','ana','202cb962ac59075b964b07152d234b70','abogado'),('2','Bruno Burgos','bruno','202cb962ac59075b964b07152d234b70','admin'),('3','Carla Cerdeña','carla','202cb962ac59075b964b07152d234b70','admin'),('4','Diego Dublin','diego','202cb962ac59075b964b07152d234b70','abogado');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-30 12:49:33
