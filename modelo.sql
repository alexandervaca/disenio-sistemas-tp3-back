--
-- Base de datos: `superbuy`
--

-- --------------------------------------------------------

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
  `producto_categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id_producto`),
  CONSTRAINT `producto_categoria` FOREIGN KEY (`producto_categoria_id`) REFERENCES categorias (`id_categoria`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`),
  UNIQUE KEY `desc_producto_UNIQUE` (`desc_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

