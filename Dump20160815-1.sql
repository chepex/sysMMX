-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sysmmx
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

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
-- Table structure for table `bodega`
--

use sysmmx;

DROP TABLE IF EXISTS `bodega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bodega` (
  `idbodega` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idbodega`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodega`
--

LOCK TABLES `bodega` WRITE;
/*!40000 ALTER TABLE `bodega` DISABLE KEYS */;
INSERT INTO `bodega` VALUES (1,'Bodega principal','bodega central',1,NULL,NULL,NULL,NULL),(2,'Bodega 2 ','Bodega 2',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bodega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Bebida',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'cliente1 ','descripcion','2222222','cliente@mas.com',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idcompra` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `total` decimal(14,3) DEFAULT NULL,
  `proveedor_idproveedor` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idcompra`),
  KEY `fk_compra_proveedor1_idx` (`proveedor_idproveedor`),
  KEY `fk_compra_usuario1_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_compra_proveedor1` FOREIGN KEY (`proveedor_idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (10,NULL,'2016-01-01',100,100.000,1,1,NULL,NULL,NULL,NULL),(11,NULL,'2016-02-01',200,200.000,1,1,NULL,NULL,NULL,NULL),(12,NULL,'2016-03-01',150,150.000,1,1,NULL,NULL,NULL,NULL),(13,NULL,'2016-04-01',100,100.000,1,1,NULL,NULL,NULL,NULL),(14,NULL,'2016-05-01',175,175.000,1,1,NULL,NULL,NULL,NULL),(15,NULL,'2016-06-01',200,200.000,1,1,NULL,NULL,NULL,NULL),(16,NULL,'2015-01-01',100,100.000,1,1,NULL,NULL,NULL,NULL),(17,NULL,'2015-02-01',150,150.000,1,1,NULL,NULL,NULL,NULL),(18,NULL,'2015-03-01',75,75.000,1,1,NULL,NULL,NULL,NULL),(19,NULL,'2015-04-01',100,100.000,1,1,NULL,NULL,NULL,NULL),(20,NULL,'2015-05-01',150,150.000,1,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_det`
--

DROP TABLE IF EXISTS `compra_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra_det` (
  `idcompra_det` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `precio` decimal(14,3) DEFAULT NULL,
  `producto_idproducto` int(11) NOT NULL,
  `compra_idcompra` int(11) NOT NULL,
  `total` decimal(14,3) DEFAULT NULL,
  PRIMARY KEY (`idcompra_det`),
  KEY `fk_compra_det_producto1_idx` (`producto_idproducto`),
  KEY `fk_compra_det_compra1_idx` (`compra_idcompra`),
  CONSTRAINT `fk_compra_det_compra1` FOREIGN KEY (`compra_idcompra`) REFERENCES `compra` (`idcompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_det_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_det`
--

LOCK TABLES `compra_det` WRITE;
/*!40000 ALTER TABLE `compra_det` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correlativo`
--

DROP TABLE IF EXISTS `correlativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `correlativo` (
  `idcorrelativo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `prefijo` varchar(50) DEFAULT NULL,
  `valor_actual` int(11) DEFAULT NULL,
  `valor_inicial` int(11) DEFAULT NULL,
  `valor_final` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `activo` tinyint(4) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idcorrelativo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correlativo`
--

LOCK TABLES `correlativo` WRITE;
/*!40000 ALTER TABLE `correlativo` DISABLE KEYS */;
INSERT INTO `correlativo` VALUES (1,'Compra','comp',2,1,100,'2016-01-01',NULL,NULL,NULL,NULL,NULL),(2,'Factura','fac',3,1,100,'2016-01-01',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `correlativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento` (
  `iddocumento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `suma_resta` varchar(1) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`iddocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (1,'Ingreso','Ingreso','S',1,NULL,NULL,NULL,NULL),(2,'Salida','Salida','R',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(45) DEFAULT NULL COMMENT 'correlativo generado',
  `fecha` date DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `iva` decimal(14,3) DEFAULT NULL,
  `retencion` decimal(14,3) DEFAULT NULL,
  `total` decimal(14,3) DEFAULT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `fk_factura_cliente1_idx` (`cliente_idcliente`),
  KEY `fk_factura_usuario1_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_factura_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,'No corelt','2016-08-12',22,NULL,NULL,44.000,1,1,NULL,NULL,NULL,NULL),(2,'fac3','2016-08-12',24,NULL,NULL,48.000,1,1,NULL,NULL,NULL,NULL),(3,'','2016-01-01',22,0.000,0.000,55.000,1,1,NULL,NULL,NULL,NULL),(4,NULL,'2016-02-01',25,0.000,0.000,44.000,1,1,NULL,NULL,NULL,NULL),(5,NULL,'2016-03-01',45,0.000,0.000,88.000,1,1,NULL,NULL,NULL,NULL),(8,NULL,'2016-04-01',30,0.000,0.000,66.000,1,1,NULL,NULL,NULL,NULL),(11,NULL,'2016-05-01',29,0.000,0.000,55.000,1,1,NULL,NULL,NULL,NULL),(12,NULL,'2016-06-01',25,0.000,0.000,44.000,1,1,NULL,NULL,NULL,NULL),(13,NULL,'2016-07-01',20,0.000,0.000,33.000,1,1,NULL,NULL,NULL,NULL),(26,NULL,'2015-01-01',20,0.000,0.000,25.000,1,1,NULL,NULL,NULL,NULL),(27,NULL,'2015-02-01',25,0.000,0.000,30.000,1,1,NULL,NULL,NULL,NULL),(28,NULL,'2015-03-01',35,0.000,0.000,45.000,1,1,NULL,NULL,NULL,NULL),(29,NULL,'2015-04-01',29,0.000,0.000,35.000,1,1,NULL,NULL,NULL,NULL),(30,NULL,'2015-05-01',40,0.000,0.000,50.000,1,1,NULL,NULL,NULL,NULL),(31,NULL,'2015-06-01',88,0.000,0.000,70.000,1,1,NULL,NULL,NULL,NULL),(32,NULL,'2015-07-01',45,0.000,0.000,60.000,1,1,NULL,NULL,NULL,NULL),(33,NULL,'2015-08-01',35,0.000,0.000,37.000,1,1,NULL,NULL,NULL,NULL),(34,NULL,'2015-09-01',20,0.000,0.000,25.000,1,1,NULL,NULL,NULL,NULL),(35,NULL,'2015-10-01',29,0.000,0.000,35.000,1,1,NULL,NULL,NULL,NULL),(36,NULL,'2015-11-01',35,0.000,0.000,40.000,1,1,NULL,NULL,NULL,NULL),(37,NULL,'2015-12-01',110,0.000,0.000,90.000,1,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura_det`
--

DROP TABLE IF EXISTS `factura_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura_det` (
  `idfactura_det` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `precio` decimal(14,3) DEFAULT NULL,
  `factura_idfactura` int(11) NOT NULL,
  `producto_idproducto` int(11) NOT NULL,
  `total` decimal(14,3) DEFAULT NULL,
  PRIMARY KEY (`idfactura_det`),
  KEY `fk_factura_det_factura1_idx` (`factura_idfactura`),
  KEY `fk_factura_det_producto1_idx` (`producto_idproducto`),
  CONSTRAINT `fk_factura_det_factura1` FOREIGN KEY (`factura_idfactura`) REFERENCES `factura` (`idfactura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_det_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura_det`
--

LOCK TABLES `factura_det` WRITE;
/*!40000 ALTER TABLE `factura_det` DISABLE KEYS */;
INSERT INTO `factura_det` VALUES (1,2,2.000,2,1,NULL),(2,22,2.000,2,1,NULL);
/*!40000 ALTER TABLE `factura_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inv_detm`
--

DROP TABLE IF EXISTS `inv_detm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inv_detm` (
  `idinv_detm` int(11) NOT NULL AUTO_INCREMENT,
  `inv_mov_idinv_mov` int(11) NOT NULL,
  `producto_idproducto` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idinv_detm`),
  KEY `fk_inv_detm_inv_mov1_idx` (`inv_mov_idinv_mov`),
  KEY `fk_inv_detm_producto1_idx` (`producto_idproducto`),
  CONSTRAINT `fk_inv_detm_inv_mov1` FOREIGN KEY (`inv_mov_idinv_mov`) REFERENCES `inv_mov` (`idinv_mov`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inv_detm_producto1` FOREIGN KEY (`producto_idproducto`) REFERENCES `producto` (`idproducto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inv_detm`
--

LOCK TABLES `inv_detm` WRITE;
/*!40000 ALTER TABLE `inv_detm` DISABLE KEYS */;
INSERT INTO `inv_detm` VALUES (1,10,1,1),(2,4,1,33),(3,3,1,4);
/*!40000 ALTER TABLE `inv_detm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inv_mov`
--

DROP TABLE IF EXISTS `inv_mov`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inv_mov` (
  `idinv_mov` int(11) NOT NULL AUTO_INCREMENT,
  `num_docto` varchar(45) DEFAULT NULL COMMENT 'corelativo por tipo de documento',
  `fecha` date DEFAULT NULL,
  `estado` varchar(1) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `id_proveedor` int(11) DEFAULT NULL,
  `bodega_idbodega` int(11) NOT NULL,
  `documento_iddocumento` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `num_referencia` varchar(50) DEFAULT NULL COMMENT 'referencia de factura o compra',
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idinv_mov`),
  KEY `fk_inv_mov_bodega1_idx` (`bodega_idbodega`),
  KEY `fk_inv_mov_documento1_idx` (`documento_iddocumento`),
  KEY `fk_inv_mov_usuario1_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_inv_mov_bodega1` FOREIGN KEY (`bodega_idbodega`) REFERENCES `bodega` (`idbodega`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inv_mov_documento1` FOREIGN KEY (`documento_iddocumento`) REFERENCES `documento` (`iddocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_inv_mov_usuario1` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inv_mov`
--

LOCK TABLES `inv_mov` WRITE;
/*!40000 ALTER TABLE `inv_mov` DISABLE KEYS */;
INSERT INTO `inv_mov` VALUES (1,'123123','2016-08-12',NULL,7,NULL,1,1,1,NULL,NULL,NULL,NULL,NULL),(2,'','2016-08-12',NULL,0,NULL,1,2,1,NULL,NULL,NULL,NULL,NULL),(3,'','2016-08-12',NULL,9,NULL,1,2,1,NULL,NULL,NULL,NULL,NULL),(4,'22','2016-08-12',NULL,55,NULL,1,1,1,NULL,NULL,NULL,NULL,NULL),(5,'','2016-08-12',NULL,22,NULL,1,1,1,NULL,NULL,NULL,NULL,NULL),(6,'','2016-08-12',NULL,33,NULL,1,1,1,NULL,NULL,NULL,NULL,NULL),(7,'','2016-08-12',NULL,7,NULL,1,1,1,NULL,NULL,NULL,NULL,NULL),(8,'','2016-08-12',NULL,1,NULL,1,2,1,NULL,NULL,NULL,NULL,NULL),(9,'','2016-08-12',NULL,22,NULL,1,1,1,NULL,NULL,NULL,NULL,NULL),(10,'','2016-08-12',NULL,1,NULL,1,2,1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `inv_mov` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meses`
--

DROP TABLE IF EXISTS `meses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meses` (
  `idmes` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meses`
--

LOCK TABLES `meses` WRITE;
/*!40000 ALTER TABLE `meses` DISABLE KEYS */;
INSERT INTO `meses` VALUES (1,'ENERO'),(2,'FEBRERO'),(3,'MARZO'),(4,'ABRIL'),(5,'MAYO'),(6,'JUNIO'),(7,'JULIO'),(8,'AGOSTO'),(9,'SEPTIEMBRE'),(10,'OCTUBRE'),(11,'NOVIEMBRE'),(12,'DICIEMBRE');
/*!40000 ALTER TABLE `meses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `idproducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripion` varchar(50) DEFAULT NULL,
  `costo` decimal(14,4) DEFAULT NULL,
  `precio` decimal(14,4) DEFAULT NULL,
  `min` int(11) DEFAULT NULL,
  `max` int(11) DEFAULT NULL,
  `existencia` int(11) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `categoria_idcategoria` int(11) NOT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idproducto`),
  KEY `fk_producto_categoria_idx` (`categoria_idcategoria`),
  CONSTRAINT `fk_producto_categoria` FOREIGN KEY (`categoria_idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'soda lata','soda lata 500 ml',0.3500,0.5500,100,1000,60,1,1,NULL,NULL,NULL,NULL),(2,'Libro 100p','Libro 100 pagina',22.0000,10.0000,5,20,0,1,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `nit` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Proveedor1','proveedor1','123123123','123123','proveedor@mas.com','san salvador',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripn` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Usuario','usuario',1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  `rol_idrol` int(11) NOT NULL,
  `usuario_create` varchar(45) DEFAULT NULL,
  `fecha_create` date DEFAULT NULL,
  `usuario_update` varchar(45) DEFAULT NULL,
  `fecha_update` date DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_usuario_rol1_idx` (`rol_idrol`),
  CONSTRAINT `fk_usuario_rol1` FOREIGN KEY (`rol_idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'usuario1','1141643ccfa4a557e2739141372e486d',1,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_user_role`
--

DROP TABLE IF EXISTS `v_user_role`;
/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_user_role` AS SELECT 
 1 AS `usuario`,
 1 AS `password`,
 1 AS `nombre`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_user_role`
--

/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user_role` AS select `u`.`usuario` AS `usuario`,`u`.`password` AS `password`,`r`.`nombre` AS `nombre` from (`usuario` `u` join `rol` `r`) where (`r`.`idrol` = `u`.`rol_idrol`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-15 22:51:49
