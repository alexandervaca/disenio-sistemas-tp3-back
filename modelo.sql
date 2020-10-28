--
-- Base de datos: `superbuy`
--

-- --------------------------------------------------------

--2020-10-23

--
-- Estructura de tabla para la tabla `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `desc_categoria` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `id_categoria_UNIQUE` (`id_categoria`),
  UNIQUE KEY `desc_categoria_UNIQUE` (`desc_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `desc_producto` varchar(100) NOT NULL,
  `precio` decimal(18,2) NOT NULL,
  `producto_categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  CONSTRAINT `producto_categoria` FOREIGN KEY (`producto_categoria_id`) REFERENCES categorias (`id_categoria`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`),
  UNIQUE KEY `desc_producto_UNIQUE` (`desc_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


--2020-10-26

--
-- Estructura de tabla para la tabla `compras`
--

DROP TABLE IF EXISTS `compras`;
CREATE TABLE IF NOT EXISTS `compras`(
  `id_compra` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` INT(11) NOT NULL,
  `fecha_compra` DATETIME NOT NULL,
  `precio_total` decimal(20,2) NOT NULL,
  PRIMARY KEY(`id_compra`),
  UNIQUE KEY `id_compra_UNIQUE`(`id_compra`),
  CONSTRAINT `compra_usuario` FOREIGN KEY(`usuario_id`) REFERENCES usuarios(`id_usuario`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;


--
-- Estructura de tabla para la tabla `compras_detalle`
--

DROP TABLE IF EXISTS `compras_detalle`;
CREATE TABLE IF NOT EXISTS `compras_detalle` (
  `id_compra_detalle` int(11) NOT NULL AUTO_INCREMENT,
  `id_compra` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cant_producto` int(11) NOT NULL,
  `precio_producto` decimal(18,2) NOT NULL,
  PRIMARY KEY(`id_compra_detalle`),
  UNIQUE KEY `id_compra_detalle_UNIQUE` (`id_compra_detalle`),
  CONSTRAINT `compras_detalle` FOREIGN KEY (`id_compra`) REFERENCES compras (`id_compra`),
  CONSTRAINT `compras_detalle_prod` FOREIGN KEY (`id_producto`) REFERENCES productos (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

