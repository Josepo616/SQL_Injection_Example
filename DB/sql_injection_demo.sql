-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 18, 2025 at 04:17 AM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql_injection_demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `dni` varchar(15) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `saldo` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `personas`
--

INSERT INTO `personas` (`id`, `nombre`, `apellido`, `dni`, `correo`, `telefono`, `saldo`) VALUES
(1, 'Juan', 'Pérez', '12345678A', 'juan.perez@mail.com', '600123456', 1500.50),
(2, 'María', 'Gómez', '23456789B', 'maria.gomez@mail.com', '600234567', 2300.75),
(3, 'Carlos', 'López', '34567890C', 'carlos.lopez@mail.com', '600345678', 500.00),
(4, 'Ana', 'Martínez', '45678901D', 'ana.martinez@mail.com', '600456789', 1250.30),
(5, 'Luis', 'Sánchez', '56789012E', 'luis.sanchez@mail.com', '600567890', 3000.00),
(6, 'Sofía', 'Rodríguez', '67890123F', 'sofia.rodriguez@mail.com', '600678901', 750.20),
(7, 'Miguel', 'Fernández', '78901234G', 'miguel.fernandez@mail.com', '600789012', 980.60),
(8, 'Laura', 'García', '89012345H', 'laura.garcia@mail.com', '600890123', 410.90),
(9, 'David', 'Hernández', '90123456I', 'david.hernandez@mail.com', '600901234', 2200.00),
(10, 'Elena', 'Torres', '01234567J', 'elena.torres@mail.com', '600012345', 1800.75);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `PASSWORD`) VALUES
(1, 'admin', 'admin123'),
(2, 'jose', '1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
