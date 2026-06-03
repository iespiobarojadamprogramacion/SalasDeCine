-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-06-2026 a las 13:21:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `salacine`
--
CREATE DATABASE IF NOT EXISTS `salacine` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `salacine`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_Cliente` int(11) NOT NULL,
  `Nombre` varchar(200) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `fecha_nacimiento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_Cliente`, `Nombre`, `Email`, `fecha_nacimiento`) VALUES
(1, 'Jesus', 'Hentones1@gmail.com', '02/12/1992'),
(2, 'Luisa', 'Luisa123@gmail.com', '16/08/2001'),
(3, 'Pedro', 'Pedropedro@gmail.com', '04/12'),
(4, 'Rodrigo Hibernate', 'RodriHibernate@gmail.com', '02/09/2000'),
(5, 'Pedro Hibernate Interface', 'ProbandoHibernate@gmail.com', '02/02/1989'),
(6, 'Carmen', 'Carmen@gmail.com', '16/07/1991');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `titulo` varchar(200) NOT NULL,
  `duracion` int(11) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `clasificacionEdad` enum('SIETE','DOCE','DIECISEIS','DIECIOCHO') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`titulo`, `duracion`, `genero`, `clasificacionEdad`) VALUES
('Efecto', 147, 'Accion', 'SIETE'),
('Elegidos', 152, 'Accion', 'DIECISEIS'),
('Lobezno', 139, 'SuperHeroes', 'DOCE'),
('SpiderMan', 158, 'SuperHeroes', 'SIETE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_Cliente`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`titulo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;


--USUARIO PARA LA BBDD
CREATE USER 'clientes'@localhost IDENTIFIED BY '12345678';
GRANT ALL privileges ON `salacine`.* TO 'clientes'@localhost IDENTIFIED BY
'12345678';


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
