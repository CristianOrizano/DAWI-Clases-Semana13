CREATE DATABASE  IF NOT EXISTS `clinica_kvbe_2022_1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clinica_kvbe_2022_1`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica_kvbe_2022_1
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `num_bol` int NOT NULL AUTO_INCREMENT,
  `cod_cli` int DEFAULT NULL,
  `cod_usu` int DEFAULT NULL,
  `fec_emi_bol` date DEFAULT NULL,
  `monto_bol` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `fk4` (`cod_usu`),
  KEY `fk5` (`cod_cli`),
  CONSTRAINT `fk4` FOREIGN KEY (`cod_usu`) REFERENCES `tb_usuario` (`cod_usu`),
  CONSTRAINT `fk5` FOREIGN KEY (`cod_cli`) REFERENCES `tb_cliente` (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--

LOCK TABLES `tb_boleta` WRITE;
/*!40000 ALTER TABLE `tb_boleta` DISABLE KEYS */;
INSERT INTO `tb_boleta` VALUES (8,1,1,'2020-05-14',555),(10,1,1,'2020-05-19',555),(11,1,1,'2021-05-19',1500),(12,1,1,'2021-05-19',1500),(13,1,2,'2021-05-19',2000),(14,1,1,'2021-05-20',1500),(15,1,1,'2022-08-08',1000),(16,1,1,'2022-10-10',1000),(17,1,1,'2022-10-10',1000),(18,1,1,'2020-12-12',1000),(19,1,1,'2022-02-02',1000),(21,1,1,'2022-02-02',1000),(22,1,1,'2022-02-02',1000),(23,1,2,'2020-02-02',1000),(24,1,2,'2020-02-05',1000),(25,1,1,'2020-02-10',1000);
/*!40000 ALTER TABLE `tb_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `cod_cli` int NOT NULL AUTO_INCREMENT,
  `nom_cli` varchar(30) DEFAULT NULL,
  `pat_cli` varchar(30) DEFAULT NULL,
  `mat_cli` varchar(30) DEFAULT NULL,
  `sex_cli` varchar(15) DEFAULT NULL,
  `dni_cli` int DEFAULT NULL,
  `fec_nac_cli` date DEFAULT NULL,
  `cel_cli` int DEFAULT NULL,
  `dir_cli` varchar(50) DEFAULT NULL,
  `cod_dis` int DEFAULT NULL,
  PRIMARY KEY (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'Luis','Mora','Ayala','Masculino',40770863,'2010-12-24',9916018,'',1265);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_enlace`
--

DROP TABLE IF EXISTS `tb_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_enlace` (
  `idenlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenlace`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_enlace`
--

LOCK TABLES `tb_enlace` WRITE;
/*!40000 ALTER TABLE `tb_enlace` DISABLE KEYS */;
INSERT INTO `tb_enlace` VALUES (1,'Medicamento','/medicamento/lis'),(2,'Laboratorio','registroLaboratorio.jsf'),(3,'Cliente','registroCliente.jsf'),(4,'Empleado','registroEmpleado.jsf'),(5,'Boleta','/venta/boleta');
/*!40000 ALTER TABLE `tb_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_especialidad`
--

DROP TABLE IF EXISTS `tb_especialidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_especialidad` (
  `cod_esp` int NOT NULL AUTO_INCREMENT,
  `nom_des` varchar(30) DEFAULT NULL,
  `cod_sede` int DEFAULT NULL,
  PRIMARY KEY (`cod_esp`),
  KEY `fk_sed` (`cod_sede`),
  CONSTRAINT `fk_sed` FOREIGN KEY (`cod_sede`) REFERENCES `tb_sede` (`cod_sed`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_especialidad`
--

LOCK TABLES `tb_especialidad` WRITE;
/*!40000 ALTER TABLE `tb_especialidad` DISABLE KEYS */;
INSERT INTO `tb_especialidad` VALUES (1,'Alergología',1),(2,'Cardiología',1),(3,'Dermatología',1),(4,'Ecografía',2),(5,'Endocrinología',2),(6,'Gastroenterología',2),(7,'Geriatría',3),(8,'Ginecología Oncológica',3),(9,'Ginecología Oncológica',3);
/*!40000 ALTER TABLE `tb_especialidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_laboratorio`
--

DROP TABLE IF EXISTS `tb_laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_laboratorio` (
  `id_lab` int NOT NULL AUTO_INCREMENT,
  `nom_lab` varchar(50) DEFAULT NULL,
  `dir_lab` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id_lab`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_laboratorio`
--

LOCK TABLES `tb_laboratorio` WRITE;
/*!40000 ALTER TABLE `tb_laboratorio` DISABLE KEYS */;
INSERT INTO `tb_laboratorio` VALUES (1,'ABBOT LABORATORIOS S.A.','Av. República de Panamá 3591 piso 7-San isidro – Lima 27'),(2,'ALCON PHARMACEUTICAL PERU','Las Begonias 441 piso 3-San Isidro'),(3,'B. BRAUN MEDICAL PERÚ S.A.','Av. Separadora Industrial No. 887-Urb. Miguel Grau Ate'),(4,'BAYER S.A.','Av. Paseo de la República No. 3074, Piso 10-San Isidro'),(5,'BIOTOSCANA FARMA DE PERÚ S.A.C.','Av. República de Panamá Nro. 3591 Int. 1301-San Isidro'),(6,'BRISAFARMA S.A.C.','Ca. Sebastian Barranca No. 245-Urb. San José-Bellavista'),(7,'BRISTOL MYERS SQUIBB PERÚ S.A.','Av. Canaval y Moreyra No. 380, Piso 6-San Isidro'),(8,'CIFARMA S.A.','Ca. Central Km. 3 No. 1315-Santa Anita'),(9,'CORPORACIÓN OLORTEGUI – CECIFARMA GROUP','Av. Industrial 160-Urbanización AuroraAte Vitarte'),(10,'DEUTSCHE PHARMA SAC','Jr. Rio de Janeiro Nº 339-Jesús María'),(11,'IQ FARMA INSTITUTO QUIMIOTERAPICO S.A','Av. Santa Rosa 350-Santa Anita'),(12,'GENZYME PERÚ SAC','AV. JORGE BASADRE NRO. 592 INT. 509-San Isidro'),(13,'JANSSEN / J&J Perú','Av. Carnaval y Moreyra 480 Piso 13-San Isidro – Lima'),(14,'JHONSON & JHONSON','Av. Carnaval y Moreyra 480 Piso 9-San Isidro- Lima'),(15,'LABORATORIO FARMACÉUTICO S.J. ROXFARMA','Av. Mendiola, 5648-Las Infantas, Los Olivos'),(19,'nini','los');
/*!40000 ALTER TABLE `tb_laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medicamento`
--

DROP TABLE IF EXISTS `tb_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_medicamento` (
  `cod_med` int NOT NULL AUTO_INCREMENT,
  `nom_med` varchar(50) DEFAULT NULL,
  `des_med` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sto_med` int DEFAULT NULL,
  `pre_med` double DEFAULT NULL,
  `fec_fab_med` date DEFAULT NULL,
  `cod_tipo` int DEFAULT NULL,
  `foto` longblob,
  `nom_archivo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_med`),
  KEY `fk_01` (`cod_tipo`),
  CONSTRAINT `fk_01` FOREIGN KEY (`cod_tipo`) REFERENCES `tb_tipo_medicamento` (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medicamento`
--

LOCK TABLES `tb_medicamento` WRITE;
/*!40000 ALTER TABLE `tb_medicamento` DISABLE KEYS */;
INSERT INTO `tb_medicamento` VALUES (1,'Paracetamol 500 nini','Paracetamol nini',20,5.6,'2022-01-01',10,NULL,NULL),(2,'Simvastatin gamer','Se emplea para reducir el colesterol y los triglicéridos (tipo de grasa) en la sangre. Descubierta y desarrollada por Merck, se trata del primer medicamento con estatina que evidencia una disminución de la enfermedad cardiovascular y mortalidad. Está en la lista modelo de medicamentos esenciales de la Organización Mundial de la Salud, en la que se describen los más importantes y necesarios en el sistema sanitario básico.',1,22,'2021-03-01',3,NULL,NULL),(3,'Aspirina','También conocida como Ácido acetilsalicílico (ASA), reduce las sustancias en el cuerpo que producen dolor, fiebre e inflamación. Es el medicamento más usado en todo el mundo y se calcula que cada año se consumen unas 40.000 toneladas.',20,22,'2021-03-01',15,NULL,NULL),(4,'Omeprazol ','inhibe la bomba de protones (IBPS)y disminuye la producción de Ácido al bloquear la enzima de la pared del estomago que se encarga de producir esta sustancia. Este efecto reviene las ulceras y tiene un resultado curativo sobre las ulceras existentes en el esófago, estomago y duodeno. La OMS lo incluye como medicamento básico.',20,5,'2021-03-10',1,NULL,NULL),(5,'Lexotiroxina sódica','Se encarga de sustituir una hormona que se suele producir en nuestra glándula tiroidea para regular la energía y el metabolismo del cuerpo. Es una versión artificial de la hormona tiroxina, responsable de aumentar la tasa metabólica de las células de todos los tejidos del organismo y ayuda a mantener la función cerebral, la absorción de los alimentos y la temperatura corporal, entre otros efectos. También la lista de la OMS.',25,25.6,'2025-06-24',2,NULL,NULL),(51,'Amelia Dow','fg',20,12,'2022-09-13',13,NULL,NULL),(53,'Olivia isa','el best gilr',20,12,'2022-10-03',4,NULL,NULL),(71,'Liv made','Rooneey cameron',20,14,'2022-09-20',13,NULL,NULL),(88,'Amelia','gfh',20,12,'2022-09-11',12,NULL,NULL),(91,'gj','hg',20,12,'2022-09-13',11,NULL,NULL),(92,'hgj','hg',20,12,'2022-09-12',14,NULL,NULL),(93,'fg','hgf',20,12,'2022-09-27',11,NULL,NULL),(94,'ghj','ghj',20,12,'2022-09-12',12,NULL,NULL),(95,'hgj','ghj',20,12,'2022-09-27',13,NULL,NULL),(96,'jhk','hj',20,12,'2022-09-26',12,NULL,NULL),(97,'hgj','hgj',20,12,'2022-09-20',4,NULL,NULL),(98,'Amelia','cretrt',20,12,'2022-10-03',14,NULL,NULL),(99,'Amelia','hg',20,12,'2022-09-26',7,NULL,NULL),(101,'Alex','larusso',20,12,'2022-09-20',9,NULL,NULL),(105,'Amelia','fgdfg',20,14,'2022-09-19',10,NULL,NULL),(106,'Dirk','fdgfd',20,12,'2022-09-04',9,NULL,NULL),(107,'Amelia','fdg',20,12,'2022-09-20',14,NULL,NULL),(108,'emma','fgh',20,12,'2022-09-20',11,NULL,NULL),(109,'Amelia','dfgdgd',20,12,'2022-09-13',13,NULL,NULL),(110,'Amelia','dfgdgd',20,12,'2022-09-13',13,NULL,NULL),(111,'Paracetamol 500 mom','dsf',1,12,'2022-09-14',11,NULL,NULL),(112,'Simvastatina','fghf',20,12,'2022-09-19',9,NULL,NULL),(113,'Amelia','fg',20,12,'2022-09-19',11,NULL,NULL),(114,'CRi','gh',20,12,'2022-09-26',12,NULL,NULL),(115,'hgj','dfg',20,12,'2022-09-11',10,NULL,NULL),(116,'Paracetamol 500 mom','hgfh',20,12,'2022-09-20',7,NULL,NULL),(117,'amlica','ergt',20,12,'2022-09-19',12,NULL,NULL),(118,'fgh','gh',20,12,'2022-09-26',9,NULL,NULL),(119,'dfg','gdf',20,12,'2022-09-11',9,NULL,NULL),(120,'Nini salazar','hifg',20,12,'2022-09-19',12,NULL,NULL),(121,'oliv','dgdf',20,12,'2022-09-13',9,NULL,NULL),(122,'Lyan','dsf',20,12,'2022-09-19',8,NULL,NULL),(123,'Amelia','gdffdg',20,12,'2022-09-12',8,NULL,NULL),(136,'Simvastatina','fff',20,12,'2022-09-12',4,NULL,NULL),(139,'Amelia','dfg',20,12,'2022-09-05',9,NULL,NULL),(146,'Jessi','wisconsifv ',20,5.6,'2022-10-19',1,NULL,NULL),(164,'cristian','emman',20,5.6,'2023-02-07',7,NULL,NULL),(165,'Amelia','fddfg',20,5.6,'2023-02-20',3,NULL,NULL),(166,'Amelia','dfgdfg',20,5.6,'2023-01-31',3,NULL,NULL),(167,'Amelia','ytr',20,5.6,'2023-02-07',5,NULL,NULL),(168,'Jeef tribal','dfgdf',20,5.6,'2023-02-02',4,NULL,NULL),(169,'roman','dfgfd',20,5.6,'2023-01-30',4,NULL,NULL),(170,'roman je','dfgfd',20,5.6,'2023-01-30',4,NULL,NULL),(171,'roman','fdgdf',20,5.6,'2023-02-13',15,NULL,NULL),(172,'Paracetamol 500 nini','dfgfd',20,5.6,'2023-02-10',3,NULL,NULL);
/*!40000 ALTER TABLE `tb_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medicamento_has_boleta`
--

DROP TABLE IF EXISTS `tb_medicamento_has_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_medicamento_has_boleta` (
  `num_bol` int NOT NULL,
  `cod_med` int NOT NULL,
  `pre` double DEFAULT NULL,
  KEY `fk6` (`num_bol`),
  KEY `fk7` (`cod_med`),
  CONSTRAINT `fk6` FOREIGN KEY (`num_bol`) REFERENCES `tb_boleta` (`num_bol`),
  CONSTRAINT `fk7` FOREIGN KEY (`cod_med`) REFERENCES `tb_medicamento` (`cod_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medicamento_has_boleta`
--

LOCK TABLES `tb_medicamento_has_boleta` WRITE;
/*!40000 ALTER TABLE `tb_medicamento_has_boleta` DISABLE KEYS */;
INSERT INTO `tb_medicamento_has_boleta` VALUES (8,1,555),(10,1,555),(10,2,5),(11,2,500),(12,2,500),(13,2,555),(14,2,500),(15,1,5.6),(15,3,22),(16,1,5.6),(16,2,22),(16,3,22),(16,4,5),(16,5,25.6),(17,1,5.6),(18,1,5.6),(18,2,22),(18,3,22),(18,4,5),(18,5,25.6),(18,51,12),(19,1,5.6),(19,2,22),(21,1,5.6),(21,2,22),(22,1,5.6),(23,2,22),(23,3,22),(24,1,5.6),(24,2,22),(24,3,22),(25,1,5.6),(25,2,22);
/*!40000 ALTER TABLE `tb_medicamento_has_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medico`
--

DROP TABLE IF EXISTS `tb_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_medico` (
  `cod_med` int NOT NULL AUTO_INCREMENT,
  `nom_med` varchar(30) DEFAULT NULL,
  `pat_med` varchar(30) DEFAULT NULL,
  `mat_med` varchar(30) DEFAULT NULL,
  `fec_nac_med` date DEFAULT NULL,
  `est_civil_med` varchar(15) DEFAULT NULL,
  `num_hijos_med` int DEFAULT NULL,
  `cod_esp_med` int DEFAULT NULL,
  PRIMARY KEY (`cod_med`),
  KEY `FK_001` (`cod_esp_med`),
  CONSTRAINT `FK_001` FOREIGN KEY (`cod_esp_med`) REFERENCES `tb_especialidad` (`cod_esp`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medico`
--

LOCK TABLES `tb_medico` WRITE;
/*!40000 ALTER TABLE `tb_medico` DISABLE KEYS */;
INSERT INTO `tb_medico` VALUES (1,'cristian','orizano','huyhu','2022-10-09','Casado(a)',5,4),(2,'Amelia','orizano','huyhu','2022-10-11','Casado(a)',2,2),(4,'nini sal','orisd','sda','2022-04-25','Soltero(a)',8,1),(5,'Paracetamol 500 mom','orizano','huyhu','2022-10-18','Soltero(a)',4,5),(6,'Amelia','orizano','huyhu','2022-10-12','Casado(a)',45,1),(9,'Nini Liv','Robert gaem','Salazar','2022-10-10','Soltera',4,8),(10,'Amelia','orizano','huyhu','2022-10-12','Soltero(a)',45,1),(11,'Ameliaca','vulgler','huyhu','2022-10-26','Soltera',2,7),(12,'Lucas','gamer','Salazar','2022-10-12','Casado(a)',4,2),(13,'Amelia','orizano','huyhu','2022-10-11','Casado(a)',2,2),(14,'Surg','Goblin','Salazar','2022-10-21','Soltero(a)',4,5);
/*!40000 ALTER TABLE `tb_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol`
--

DROP TABLE IF EXISTS `tb_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol`
--

LOCK TABLES `tb_rol` WRITE;
/*!40000 ALTER TABLE `tb_rol` DISABLE KEYS */;
INSERT INTO `tb_rol` VALUES (1,'Administrador'),(2,'Caja'),(3,'Contabilidad');
/*!40000 ALTER TABLE `tb_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol_enlace`
--

DROP TABLE IF EXISTS `tb_rol_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol_enlace` (
  `idrol` int NOT NULL,
  `idenlace` int NOT NULL,
  PRIMARY KEY (`idrol`,`idenlace`),
  KEY `fk25` (`idenlace`),
  CONSTRAINT `fk24` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`),
  CONSTRAINT `fk25` FOREIGN KEY (`idenlace`) REFERENCES `tb_enlace` (`idenlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol_enlace`
--

LOCK TABLES `tb_rol_enlace` WRITE;
/*!40000 ALTER TABLE `tb_rol_enlace` DISABLE KEYS */;
INSERT INTO `tb_rol_enlace` VALUES (1,1),(2,1),(1,2),(3,2),(1,3),(1,4),(1,5),(2,5);
/*!40000 ALTER TABLE `tb_rol_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sede`
--

DROP TABLE IF EXISTS `tb_sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_sede` (
  `cod_sed` int NOT NULL,
  `nom_sed` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_sed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sede`
--

LOCK TABLES `tb_sede` WRITE;
/*!40000 ALTER TABLE `tb_sede` DISABLE KEYS */;
INSERT INTO `tb_sede` VALUES (1,'Los olivos'),(2,'Breña'),(3,'Surco');
/*!40000 ALTER TABLE `tb_sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_medicamento`
--

DROP TABLE IF EXISTS `tb_tipo_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_medicamento` (
  `cod_tipo` int NOT NULL AUTO_INCREMENT,
  `nom_tipo` varchar(50) DEFAULT NULL,
  `cod_lab` int DEFAULT NULL,
  PRIMARY KEY (`cod_tipo`),
  KEY `fk_cod` (`cod_lab`),
  CONSTRAINT `fk_cod` FOREIGN KEY (`cod_lab`) REFERENCES `tb_laboratorio` (`id_lab`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_medicamento`
--

LOCK TABLES `tb_tipo_medicamento` WRITE;
/*!40000 ALTER TABLE `tb_tipo_medicamento` DISABLE KEYS */;
INSERT INTO `tb_tipo_medicamento` VALUES (1,'Analgesicos',3),(2,'Ansioliticos e hipneticos',1),(3,'Antiacidos',3),(4,'Antibacticos',2),(5,'Antidiarreicos',2),(6,'Antigripales',2),(7,'Antihistamanicos',1),(8,'Antiinflamatorios',3),(9,'Antimicaticos',3),(10,'Antipirticos',4),(11,'Anticepticos',4),(12,'Antitusivos',1),(13,'Broncodilatadores',5),(14,'Expectorantes',5),(15,'Laxantes',1),(16,'Mucoliticos',6);
/*!40000 ALTER TABLE `tb_tipo_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `cod_usu` int NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  `nom_usu` varchar(45) DEFAULT NULL,
  `ape_usu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `fk23` (`idrol`),
  CONSTRAINT `fk23` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'ana','$2a$10$7WFjDFzlupeTLr5kUdECxe.g43J0D.evs/AwacCA9bJoZZkDILvm2',1,'aaa','bbbbb'),(2,'maria','$2a$10$7WFjDFzlupeTLr5kUdECxe.g43J0D.evs/AwacCA9bJoZZkDILvm2',2,'nini','sal'),(3,'cris','$2a$10$7WFjDFzlupeTLr5kUdECxe.g43J0D.evs/AwacCA9bJoZZkDILvm2',3,'surg','gob');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'clinica_kvbe_2022_1'
--

--
-- Dumping routines for database 'clinica_kvbe_2022_1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-27 18:51:04
