--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `desc_categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `id_categorias_UNIQUE` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
CREATE TABLE `compras` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `fecha_compra` datetime NOT NULL,
  `precio_total` decimal(25,2) NOT NULL,
  PRIMARY KEY (`id_compra`),
  UNIQUE KEY `id_compra_UNIQUE` (`id_compra`),
  KEY `compra_usuario` (`usuario_id`),
  CONSTRAINT `compra_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Table structure for table `compras_detalle`
--

DROP TABLE IF EXISTS `compras_detalle`;
CREATE TABLE `compras_detalle` (
  `id_compra_detalle` int NOT NULL AUTO_INCREMENT,
  `id_compra` int NOT NULL,
  `id_producto` int NOT NULL,
  `cant_producto` int NOT NULL,
  PRIMARY KEY (`id_compra_detalle`),
  UNIQUE KEY `id_compra_detalle_UNIQUE` (`id_compra_detalle`),
  KEY `compras_detalle` (`id_compra`),
  KEY `compras_detalle_prod` (`id_producto`),
  CONSTRAINT `compras_detalle` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `compras_detalle_prod` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Table structure for table `notificaciones`
--

DROP TABLE IF EXISTS `notificaciones`;
CREATE TABLE `notificaciones` (
  `id_notificacion` int NOT NULL AUTO_INCREMENT,
  `id_compra` int NOT NULL,
  `id_usuario` int NOT NULL,
  `message` varchar(120) NOT NULL,
  PRIMARY KEY (`id_notificacion`),
  UNIQUE KEY `id_notificaciones_UNIQUE` (`id_notificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
CREATE TABLE `permisos` (
  `id_permiso` int NOT NULL,
  `desc_permiso` varchar(45) NOT NULL,
  PRIMARY KEY (`id_permiso`),
  UNIQUE KEY `id_permiso_UNIQUE` (`id_permiso`),
  UNIQUE KEY `desc_permiso_UNIQUE` (`desc_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `desc_producto` varchar(100) NOT NULL,
  `precio` decimal(18,2) NOT NULL,
  `id_usuario` int NOT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  `stock` int NOT NULL,
  `habilitado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `mail` varchar(60) NOT NULL,
  `habilitado` tinyint NOT NULL DEFAULT '0',
  `id_categoria` varchar(45) DEFAULT NULL,
  `nombre` varchar(90) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `usuarios_permisos`
--

DROP TABLE IF EXISTS `usuarios_permisos`;
CREATE TABLE `usuarios_permisos` (
  `id_usuario_permiso` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `id_permiso` int NOT NULL,
  PRIMARY KEY (`id_usuario_permiso`),
  UNIQUE KEY `id_usuario_permiso_UNIQUE` (`id_usuario_permiso`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;