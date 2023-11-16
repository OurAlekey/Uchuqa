CREATE DATABASE  IF NOT EXISTS `bd_uchuqa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_uchuqa`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_uchuqa
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `imagenes`
--

DROP TABLE IF EXISTS `imagenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagenes` (
  `id_imagen` int NOT NULL AUTO_INCREMENT,
  `ima_descripcion` varchar(1000) NOT NULL,
  `id_proyecto` int NOT NULL,
  PRIMARY KEY (`id_imagen`),
  KEY `ID_Proyecto` (`id_proyecto`),
  CONSTRAINT `imagenes_ibfk_1` FOREIGN KEY (`id_proyecto`) REFERENCES `tb_proyecto` (`id_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenes`
--

LOCK TABLES `imagenes` WRITE;
/*!40000 ALTER TABLE `imagenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_asignacionetiqueta`
--

DROP TABLE IF EXISTS `tb_asignacionetiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_asignacionetiqueta` (
  `id_asignacion_etiqueta` int NOT NULL,
  `id_etiqueta` int NOT NULL,
  `proyecto_id` int NOT NULL,
  PRIMARY KEY (`id_asignacion_etiqueta`),
  KEY `ID_Etiqueta` (`id_etiqueta`),
  KEY `Proyecto_ID` (`proyecto_id`),
  CONSTRAINT `asignacionetiqueta_ibfk_1` FOREIGN KEY (`id_etiqueta`) REFERENCES `tb_etiqueta` (`id_etiqueta`),
  CONSTRAINT `asignacionetiqueta_ibfk_2` FOREIGN KEY (`proyecto_id`) REFERENCES `tb_proyecto` (`id_proyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_asignacionetiqueta`
--

LOCK TABLES `tb_asignacionetiqueta` WRITE;
/*!40000 ALTER TABLE `tb_asignacionetiqueta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_asignacionetiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_chat`
--

DROP TABLE IF EXISTS `tb_chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_chat` (
  `id_chat` int NOT NULL AUTO_INCREMENT,
  `proyecto_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `user_id2` int DEFAULT NULL,
  PRIMARY KEY (`id_chat`),
  KEY `Proyect_id` (`proyecto_id`),
  KEY `User_ID` (`user_id`),
  KEY `user_id2_idx` (`user_id2`),
  CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`proyecto_id`) REFERENCES `tb_proyecto` (`id_proyecto`),
  CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_usuario` (`id_usuario`),
  CONSTRAINT `user_id2` FOREIGN KEY (`user_id2`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_chat`
--

LOCK TABLES `tb_chat` WRITE;
/*!40000 ALTER TABLE `tb_chat` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comentarios`
--

DROP TABLE IF EXISTS `tb_comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_comentarios` (
  `id_comentario` int NOT NULL AUTO_INCREMENT,
  `com_descripcion` varchar(250) NOT NULL,
  `com_usua_id` int NOT NULL,
  `id_proyecto` int NOT NULL,
  `id_comentario_fk` int DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `Id_Proyecto` (`id_proyecto`),
  KEY `Usua_Id` (`com_usua_id`),
  KEY `ID_Comentario` (`id_comentario_fk`),
  CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`id_proyecto`) REFERENCES `tb_proyecto` (`id_proyecto`),
  CONSTRAINT `comentarios_ibfk_2` FOREIGN KEY (`com_usua_id`) REFERENCES `tb_usuario` (`id_usuario`),
  CONSTRAINT `comentarios_ibfk_3` FOREIGN KEY (`id_comentario_fk`) REFERENCES `tb_comentarios` (`id_comentario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comentarios`
--

LOCK TABLES `tb_comentarios` WRITE;
/*!40000 ALTER TABLE `tb_comentarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_contacato`
--

DROP TABLE IF EXISTS `tb_contacato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_contacato` (
  `id_contacto` int NOT NULL AUTO_INCREMENT,
  `con_descripcion` varchar(250) NOT NULL,
  `usuario_id` int NOT NULL,
  `id_tipo_contacto` int DEFAULT NULL,
  PRIMARY KEY (`id_contacto`),
  KEY `Usuario_ID` (`usuario_id`),
  KEY `id_tipo_contacto_idx` (`id_tipo_contacto`),
  CONSTRAINT `contacto_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_usuario` (`id_usuario`),
  CONSTRAINT `id_tipo_contacto` FOREIGN KEY (`id_tipo_contacto`) REFERENCES `tb_tipo_contacto` (`id_tipo_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_contacato`
--

LOCK TABLES `tb_contacato` WRITE;
/*!40000 ALTER TABLE `tb_contacato` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_contacato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_departamento`
--

DROP TABLE IF EXISTS `tb_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_departamento` (
  `id_departamento` int NOT NULL AUTO_INCREMENT,
  `dep_descripcion` varchar(250) NOT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_departamento`
--

LOCK TABLES `tb_departamento` WRITE;
/*!40000 ALTER TABLE `tb_departamento` DISABLE KEYS */;
INSERT INTO `tb_departamento` VALUES (1,'Petén'),(2,'Huehuetenango'),(3,'Quiché'),(4,'Alta verapaz'),(5,'Baja Verapaz'),(6,'San Marcos'),(7,'Quetzaltenango'),(8,'Totonicapan'),(9,'Sololá'),(10,'Retalhuleu'),(11,'Suchitepequez'),(12,'Chimaltenango'),(13,'Sacatepéquez'),(14,'Guatemala'),(15,'Escuintla'),(16,'Santa Rosa'),(17,'Jutiapa'),(18,'Jalapa'),(19,'Chiquimula'),(20,'El Progreso'),(21,'Zacapa'),(22,'Izabal');
/*!40000 ALTER TABLE `tb_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_etiqueta`
--

DROP TABLE IF EXISTS `tb_etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_etiqueta` (
  `id_etiqueta` int NOT NULL AUTO_INCREMENT,
  `eti_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_etiqueta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_etiqueta`
--

LOCK TABLES `tb_etiqueta` WRITE;
/*!40000 ALTER TABLE `tb_etiqueta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mensajes`
--

DROP TABLE IF EXISTS `tb_mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mensajes` (
  `id_mensaje` int NOT NULL AUTO_INCREMENT,
  `id_chat` int NOT NULL,
  `men_mensaje` varchar(500) NOT NULL,
  `id_usuario` int NOT NULL,
  `men_fecha_insercion` timestamp(6) NOT NULL,
  PRIMARY KEY (`id_mensaje`),
  KEY `chat_id_idx` (`id_chat`),
  KEY `id_user_idx` (`id_usuario`),
  CONSTRAINT `chat_id` FOREIGN KEY (`id_chat`) REFERENCES `tb_chat` (`id_chat`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mensajes`
--

LOCK TABLES `tb_mensajes` WRITE;
/*!40000 ALTER TABLE `tb_mensajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proyecto`
--

DROP TABLE IF EXISTS `tb_proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_proyecto` (
  `id_proyecto` int NOT NULL AUTO_INCREMENT,
  `pro_nombre` varchar(45) NOT NULL,
  `pro_descripcion` varchar(45) NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_proyecto`),
  KEY `Id_Usuario` (`id_usuario`),
  CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proyecto`
--

LOCK TABLES `tb_proyecto` WRITE;
/*!40000 ALTER TABLE `tb_proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sexo`
--

DROP TABLE IF EXISTS `tb_sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sexo` (
  `id_sexo` int NOT NULL AUTO_INCREMENT,
  `sex_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sexo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sexo`
--

LOCK TABLES `tb_sexo` WRITE;
/*!40000 ALTER TABLE `tb_sexo` DISABLE KEYS */;
INSERT INTO `tb_sexo` VALUES (1,'Femenino'),(2,'Masculino'),(3,'Otro');
/*!40000 ALTER TABLE `tb_sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_contacto`
--

DROP TABLE IF EXISTS `tb_tipo_contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_contacto` (
  `id_tipo_contacto` int NOT NULL AUTO_INCREMENT,
  `tco_descripcion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_contacto`
--

LOCK TABLES `tb_tipo_contacto` WRITE;
/*!40000 ALTER TABLE `tb_tipo_contacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipo_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipousuario`
--

DROP TABLE IF EXISTS `tb_tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipousuario` (
  `id_tipo_usuario` int NOT NULL AUTO_INCREMENT,
  `tus_descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipousuario`
--

LOCK TABLES `tb_tipousuario` WRITE;
/*!40000 ALTER TABLE `tb_tipousuario` DISABLE KEYS */;
INSERT INTO `tb_tipousuario` VALUES (1,'Admin'),(2,'Usuario');
/*!40000 ALTER TABLE `tb_tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usu_edad` int NOT NULL,
  `usu_email` varchar(45) NOT NULL,
  `usu_contra` varchar(250) NOT NULL,
  `usu_nombre` varchar(45) NOT NULL,
  `ausu_apellido` varchar(45) NOT NULL,
  `usu_perfil` varchar(1000) DEFAULT NULL,
  `usu_portada` varchar(1000) DEFAULT NULL,
  `id_departamento` int NOT NULL,
  `id_tipo_usurio` int NOT NULL,
  `id_sexo` int NOT NULL,
  `usu_descripcion` varchar(255) DEFAULT NULL,
  `usu_direccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `IdDepartamento_idx` (`id_departamento`),
  KEY `IdTipoUsuario_idx` (`id_tipo_usurio`),
  KEY `IdSexo` (`id_sexo`),
  CONSTRAINT `IdDepartamento` FOREIGN KEY (`id_departamento`) REFERENCES `tb_departamento` (`id_departamento`),
  CONSTRAINT `IdSexp` FOREIGN KEY (`id_sexo`) REFERENCES `tb_sexo` (`id_sexo`),
  CONSTRAINT `IdTipoUsuario` FOREIGN KEY (`id_tipo_usurio`) REFERENCES `tb_tipousuario` (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (3,20,'admin@gmail.com','$2a$10$6.u3d67pNtEwFeH8236oz.uB9waiXNOmLlvbD9msV1NIb8lS4I.qy','Admin','Admin',NULL,NULL,1,1,3,'soy un programador','Solola, solola'),(4,20,'yordiyach001@gmail.com','$2a$10$eDBtJ6O7D8coD57bRQwOb.vTju8/S0TEqtTVWsKiIVOakuVVxerGK','Yordi','Yach','','',9,2,2,NULL,NULL),(5,20,'yordi@gmail.com','$2a$10$Q9K57o2uUM60SYTiU8.1M.eePSuqMSFtyIXLUyrE2kJh82XbrTbk2','Yordi','Yach','','',9,2,2,NULL,NULL);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_uchuqa'
--

--
-- Dumping routines for database 'bd_uchuqa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15 22:27:39
