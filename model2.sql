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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
