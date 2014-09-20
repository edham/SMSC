CREATE DATABASE  IF NOT EXISTS `smsc_bd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `smsc_bd`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: smsc_bd
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `control`
--

DROP TABLE IF EXISTS `control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `control` (
  `id_control` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad_falso` int(11) NOT NULL,
  `cantidad_dias` int(11) NOT NULL,
  PRIMARY KEY (`id_control`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control`
--

LOCK TABLES `control` WRITE;
/*!40000 ALTER TABLE `control` DISABLE KEYS */;
/*!40000 ALTER TABLE `control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control_usuario`
--

DROP TABLE IF EXISTS `control_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `control_usuario` (
  `id_control_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_control` int(11) NOT NULL,
  PRIMARY KEY (`id_control_usuario`),
  KEY `fk_control_usuario_usuario1_idx` (`id_usuario`),
  KEY `fk_control_usuario_control1_idx` (`id_control`),
  CONSTRAINT `fk_control_usuario_control1` FOREIGN KEY (`id_control`) REFERENCES `control` (`id_control`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_control_usuario_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control_usuario`
--

LOCK TABLES `control_usuario` WRITE;
/*!40000 ALTER TABLE `control_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `control_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_personal_vehiculo`
--

DROP TABLE IF EXISTS `detalle_personal_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_personal_vehiculo` (
  `id_detalle_personal_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `id_personal_vehiculo` int(11) NOT NULL,
  `id_personal` int(11) NOT NULL,
  PRIMARY KEY (`id_detalle_personal_vehiculo`),
  KEY `fk_detalle_usuario_vehiculo_usuario_vehiculo1_idx` (`id_personal_vehiculo`),
  KEY `fk_detalle_personal_vehiculo_personal1_idx` (`id_personal`),
  CONSTRAINT `fk_detalle_personal_vehiculo_personal1` FOREIGN KEY (`id_personal`) REFERENCES `personal` (`id_personal`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_detalle_usuario_vehiculo_usuario_vehiculo1` FOREIGN KEY (`id_personal_vehiculo`) REFERENCES `personal_vehiculo` (`id_personal_vehiculo`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_personal_vehiculo`
--

LOCK TABLES `detalle_personal_vehiculo` WRITE;
/*!40000 ALTER TABLE `detalle_personal_vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_personal_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `id_distrito` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_distrito`),
  KEY `fk_distrito_provincia1_idx` (`id_provincia`),
  CONSTRAINT `fk_distrito_provincia1` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidente` (
  `id_incidente` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_incidente` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `latitud` double NOT NULL,
  `longuitud` double NOT NULL,
  `detalle` varchar(200) DEFAULT NULL,
  `foto` blob,
  `fecha_registro` datetime NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_incidente`),
  KEY `fk_incidente_tipo_incidente1_idx` (`id_tipo_incidente`),
  KEY `fk_incidente_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_incidente_tipo_incidente1` FOREIGN KEY (`id_tipo_incidente`) REFERENCES `tipo_incidente` (`id_tipo_incidente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_incidente_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
INSERT INTO `incidente` VALUES (1,1,1,-8.107127237180672,-79.01526259532312,'XD',NULL,'2014-10-10 00:00:00',0),(2,2,1,-8.107260007326138,-79.01472347131113,'GG',NULL,'2014-10-10 00:00:00',0),(3,3,1,-8.107127237180672,-79.01472347131113,'XD GG',NULL,'2014-10-10 00:00:00',0);
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `id_personal` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_personal` int(11) NOT NULL,
  `id_distrito` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `celular` varchar(9) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `latitud` double NOT NULL,
  `longuitud` double NOT NULL,
  `puntos` int(11) NOT NULL,
  `foto` blob,
  `fecha_registro` datetime NOT NULL,
  `fecha_actualizacion` datetime NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_personal`),
  KEY `fk_personal_tipo_personal_idx` (`id_tipo_personal`),
  KEY `fk_personal_distrito1_idx` (`id_distrito`),
  CONSTRAINT `fk_personal_distrito1` FOREIGN KEY (`id_distrito`) REFERENCES `distrito` (`id_distrito`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_personal_tipo_personal` FOREIGN KEY (`id_tipo_personal`) REFERENCES `tipo_personal` (`id_tipo_personal`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_vehiculo`
--

DROP TABLE IF EXISTS `personal_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_vehiculo` (
  `id_personal_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `id_vehiculo` int(11) NOT NULL,
  `id_personal` int(11) NOT NULL,
  `fecha_entrada` datetime NOT NULL,
  `fecha_salida` datetime NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_personal_vehiculo`),
  KEY `fk_usuario_vehiculo_vehiculo1_idx` (`id_vehiculo`),
  KEY `fk_personal_vehiculo_personal1_idx` (`id_personal`),
  CONSTRAINT `fk_personal_vehiculo_personal1` FOREIGN KEY (`id_personal`) REFERENCES `personal` (`id_personal`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario_vehiculo_vehiculo1` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id_vehiculo`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_vehiculo`
--

LOCK TABLES `personal_vehiculo` WRITE;
/*!40000 ALTER TABLE `personal_vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  PRIMARY KEY (`id_provincia`),
  KEY `fk_provincia_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_provincia_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recorrido_vehiculo`
--

DROP TABLE IF EXISTS `recorrido_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recorrido_vehiculo` (
  `id_recorrido_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `id_personal_vehiculo` int(11) NOT NULL,
  `latitud` double NOT NULL,
  `longuitud` double NOT NULL,
  `fecha_registro` datetime NOT NULL,
  PRIMARY KEY (`id_recorrido_vehiculo`),
  KEY `fk_recorrido_vehiculo_personal_vehiculo1_idx` (`id_personal_vehiculo`),
  CONSTRAINT `fk_recorrido_vehiculo_personal_vehiculo1` FOREIGN KEY (`id_personal_vehiculo`) REFERENCES `personal_vehiculo` (`id_personal_vehiculo`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recorrido_vehiculo`
--

LOCK TABLES `recorrido_vehiculo` WRITE;
/*!40000 ALTER TABLE `recorrido_vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `recorrido_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta_incidente`
--

DROP TABLE IF EXISTS `respuesta_incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta_incidente` (
  `id_respuesta_incidente` int(11) NOT NULL AUTO_INCREMENT,
  `id_incidente` int(11) NOT NULL,
  `id_personal_vehiculo` int(11) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_finalizacion` datetime NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `foto` blob,
  `calificacion` tinyint(4) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_respuesta_incidente`),
  KEY `fk_respuesta_incidente_incidente1_idx` (`id_incidente`),
  KEY `fk_respuesta_incidente_personal_vehiculo1_idx` (`id_personal_vehiculo`),
  CONSTRAINT `fk_respuesta_incidente_incidente1` FOREIGN KEY (`id_incidente`) REFERENCES `incidente` (`id_incidente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_respuesta_incidente_personal_vehiculo1` FOREIGN KEY (`id_personal_vehiculo`) REFERENCES `personal_vehiculo` (`id_personal_vehiculo`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta_incidente`
--

LOCK TABLES `respuesta_incidente` WRITE;
/*!40000 ALTER TABLE `respuesta_incidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta_incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_incidente`
--

DROP TABLE IF EXISTS `tipo_incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_incidente` (
  `id_tipo_incidente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `imagen` blob,
  `fecha_registro` datetime NOT NULL,
  `fecha_actualizacion` datetime NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_tipo_incidente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_incidente`
--

LOCK TABLES `tipo_incidente` WRITE;
/*!40000 ALTER TABLE `tipo_incidente` DISABLE KEYS */;
INSERT INTO `tipo_incidente` VALUES (1,'Robo','Robo',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1),(2,'Incendío','Incendío',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1),(3,'Secuestro','Secuestro',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1),(4,'Homicidio','Homicidio',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1),(5,'Accidente','Accidente',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1),(6,'Violación','Violación',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1),(7,'Otros','Otros',NULL,'2014-10-10 00:00:00','2014-10-10 00:00:00',1);
/*!40000 ALTER TABLE `tipo_incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_personal`
--

DROP TABLE IF EXISTS `tipo_personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_personal` (
  `id_tipo_personal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_tipo_personal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_personal`
--

LOCK TABLES `tipo_personal` WRITE;
/*!40000 ALTER TABLE `tipo_personal` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `celular` varchar(9) NOT NULL,
  `dni` varchar(45) NOT NULL,
  `sexo` bit(1) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `cantidad_falso` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'manuel','dias','manuel@hotmail.com','123456789','12345678','','123456','2014-10-10','2014-10-10 00:00:00',0,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `id_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `fecha_registro` datetime NOT NULL,
  `fecha_actualizacion` datetime NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo_incidente`
--

DROP TABLE IF EXISTS `vehiculo_incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo_incidente` (
  `id_apoyo_vehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `id_personal_vehiculo` int(11) NOT NULL,
  `id_tipo_incidente` int(11) NOT NULL,
  `foto` blob,
  `descripcion` varchar(200) DEFAULT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_finalizacion` datetime NOT NULL,
  `estado` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_apoyo_vehiculo`),
  KEY `fk_vehiculo_incidente_personal_vehiculo1_idx` (`id_personal_vehiculo`),
  KEY `fk_vehiculo_incidente_tipo_incidente1_idx` (`id_tipo_incidente`),
  CONSTRAINT `fk_vehiculo_incidente_personal_vehiculo1` FOREIGN KEY (`id_personal_vehiculo`) REFERENCES `personal_vehiculo` (`id_personal_vehiculo`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_vehiculo_incidente_tipo_incidente1` FOREIGN KEY (`id_tipo_incidente`) REFERENCES `tipo_incidente` (`id_tipo_incidente`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo_incidente`
--

LOCK TABLES `vehiculo_incidente` WRITE;
/*!40000 ALTER TABLE `vehiculo_incidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo_incidente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-20  9:43:41
