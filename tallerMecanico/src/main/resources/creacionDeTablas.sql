-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 05-06-2019 a las 10:19:20
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tallermecanico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coche`
--

DROP TABLE IF EXISTS `coche`;
CREATE TABLE IF NOT EXISTS `coche` (
  `id_coche` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) DEFAULT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_coche`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `coche`
--

INSERT INTO `coche` (`id_coche`, `matricula`, `marca`, `modelo`) VALUES
(1, 'ABC-123', 'uuueeee', 'asdfa'),
(5, '9999-abc', 'audi', 'a3'),
(3, 'abc-1234', 'fiat', 'punto'),
(4, '1234-btd', 'ford', 'mondeo'),
(6, '1111-abcd', 'audi', 'a3'),
(12, '111-abc', 'nuevoCoche', 'fiat'),
(10, '9999-abc', 'fiat', 'punto'),
(11, 'abc-1234', 'fiat', 'punto'),
(13, '', 'fasdfad', ''),
(14, '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario_id_usuario` int(11) DEFAULT NULL,
  `id_coche_id_coche` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `importe` float(7,2) DEFAULT NULL,
  `pagada` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `FK_USUARIO_FACTURA` (`id_usuario_id_usuario`),
  KEY `FK_COCHE_FACTURA` (`id_coche_id_coche`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `id_usuario_id_usuario`, `id_coche_id_coche`, `fecha`, `Descripcion`, `importe`, `pagada`) VALUES
(12, 4, 1, '2019-05-29', 'fecha', 1231.00, 'SI'),
(11, 4, 1, '2019-05-01', 'prueba de modificacion', 122.00, 'SI'),
(10, 4, 10, '2019-04-29', 'adsfasdf', 1231.00, 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) DEFAULT NULL,
  `apellidos` varchar(80) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `permisos` varchar(1) DEFAULT 'U',
  PRIMARY KEY (`id_usuario`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellidos`, `email`, `password`, `permisos`) VALUES
(1, 'usuario', 'usuario', 'usuario@hotmail.com', '$2a$10$rG9EutsdZa4EGjVhmsUdruiq8x4u9GTEeuBBEs9mHFrSwz3NvvQfm', 'U'),
(2, 'user', 'user', 'user', '$2a$10$aqtiZvLrlZPzGoeFgw5zu.tuNI2u59fmS4vtp4CBd3LZySayAVkYy', 'U'),
(3, 'Admin', 'Admin', 'admin@admin', '$2a$10$I5wPBGyotfTjX7XfuAg4r.s3e3/MG4egcr9cK4R7QKzTt3cc/Jqn2', 'A'),
(4, 'jajajaj', 'jjajajaj', 'yeyoperez_93@hotmail.com', '$2a$10$uHLi0TLwIeYSOI/ghGyZJORp/zOj7ueRE/p.2gPbg.fu4cMZORHGy', 'U'),
(5, 'aaaaa', 'aaaaa', 'aaaaa', '$2a$10$VffuIkPDIJdMyCSgxwUYgO9lO//Th56okEHyo2kCXHFspdtCXCJgi', 'U'),
(6, 'pruebaDefault', 'pruebaDefault', 'pruebaDefault', '$2a$10$7Nuxp.4uTa44ZpcgoL0raOrbdC8ZIdH9R27/NMt6Ll4HgpEqh6ceC', 'U'),
(9, 'enblanco', 'enblanco', 'enblanco', '$2a$10$vaqOVjpLClumM2aTxi9XjOMoOtUMzPtl77bt.R17BlkyHiPtPq7Wy', 'U'),
(8, 'miguel', 'miguel', 'miguel', '$2a$10$mHlT/lMv1OhAz2xCs8Mjvu/quHbWPA8dO5O.iFX7RJ7L5.9KBTPYK', 'U'),
(10, 'eeeeeeeeee', 'eeeeeeee', 'eeeeeeeee', '$2a$10$e3iD0JWKSMzbJ3iWPgC.LOudl46LGxzgjWlVudet5yAb0CLQ.beFW', 'U'),
(11, 'nuevoUsuario', 'apellidosdeNuevoUsuario', 'nuevoUsuario@nuevoUsuario', '$2a$10$1oSX7uSjwqqwnPqg.YJhze.vOvlmfhUXD417adSzwMs/p3MZjMhpG', 'U'),
(12, 'sergio', 'perez', 'correo@correo.com', '$2a$10$3BOPRD7EY68ZBZ9JkUWGAu95LVS5FsxXwFuo7noR4A94/7M40eaca', 'U');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
