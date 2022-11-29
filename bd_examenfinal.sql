-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `corte_laser`
--

DROP TABLE IF EXISTS `corte_laser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corte_laser` (
  `idcorte_laser` int NOT NULL AUTO_INCREMENT,
  `grosor` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `material` varchar(45) NOT NULL,
  `alto` int NOT NULL,
  `ancho` int NOT NULL,
  `url` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `usuario_idusuario` int NOT NULL,
  PRIMARY KEY (`idcorte_laser`),
  KEY `fk_corte_laser_usuario1_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_corte_laser_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corte_laser`
--

LOCK TABLES `corte_laser` WRITE;
/*!40000 ALTER TABLE `corte_laser` DISABLE KEYS */;
/*!40000 ALTER TABLE `corte_laser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escaneo_digital_3d`
--

DROP TABLE IF EXISTS `escaneo_digital_3d`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escaneo_digital_3d` (
  `idescaneo_digital_3D` int NOT NULL AUTO_INCREMENT,
  `largo` float NOT NULL,
  `ancho` float NOT NULL,
  `alto` float NOT NULL,
  `resolucion` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `usuario_idusuario` int NOT NULL,
  PRIMARY KEY (`idescaneo_digital_3D`),
  KEY `fk_escaneo_digital_3D_usuario1_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_escaneo_digital_3D_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escaneo_digital_3d`
--

LOCK TABLES `escaneo_digital_3d` WRITE;
/*!40000 ALTER TABLE `escaneo_digital_3d` DISABLE KEYS */;
/*!40000 ALTER TABLE `escaneo_digital_3d` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `impresion_3d`
--

DROP TABLE IF EXISTS `impresion_3d`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `impresion_3d` (
  `idimpresion_3D` int NOT NULL AUTO_INCREMENT,
  `densidad` int NOT NULL,
  `grosor` varchar(45) NOT NULL,
  `altura` float NOT NULL,
  `material` varchar(45) NOT NULL,
  `url` varchar(45) NOT NULL,
  `auoservicio` varchar(2) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `usuario_idusuario` int NOT NULL,
  PRIMARY KEY (`idimpresion_3D`),
  KEY `fk_impresion_3D_usuario_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_impresion_3D_usuario` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `impresion_3d`
--

LOCK TABLES `impresion_3d` WRITE;
/*!40000 ALTER TABLE `impresion_3d` DISABLE KEYS */;
/*!40000 ALTER TABLE `impresion_3d` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `password_hashed` varchar(512) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Jose','Molina Perez','interno','jose20@gmail.com','josemp','b0b0e8f7cabb2725f69339eec6fcda7e8b1c7d3c0c2c0054d5f14cb636af1b3f0450b808877903c956f97089544b4c1173cd0e049867e69a2b6b53ec9c1780c7'),(2,'Allison','Gomez Paredes','externo','agomez@gmail.com','allison','31b28301ec312f084290d57c46b57f5bda69946439615e936c3711a0ec2a98e07f7a163430a4c04e9e69c3b17edd86499af9af0207730e0464adb92b74e89b55'),(3,'Juan','Tejada Fujimori','interno','tejada51@gmail.com','tejuan','ff74a3fe1cd4cc09a5fb11f1ce04b64808461d076542f3d6795feb34cbc1260c4ab524752f8af7406f3d7a0d8ff36caccb6991e5ae425bb51a86f55ee148fe16');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-29 14:29:16
