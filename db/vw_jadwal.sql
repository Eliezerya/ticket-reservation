-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2022 at 10:42 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.3.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reserfasi_tiket_db`
--

-- --------------------------------------------------------

--
-- Structure for view `vw_jadwal`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_jadwal`  AS SELECT `jadwal`.`schedule_id` AS `id_jadwal`, `jadwal`.`selesai_tayang` AS `selesai_tayang`, `film`.`film_name` AS `film_name`, `jadwal`.`code_films` AS `code_films`, `jadwal`.`harga_tiket` AS `harga_tiket` FROM ((`films` `film` join `schedules` `jadwal` on(`jadwal`.`code_films` = `film`.`film_code`)) join `seats` `studio` on(`studio`.`schedule_id` = `jadwal`.`code_films`)) WHERE `film`.`film_status` = 1 ;

--
-- VIEW `vw_jadwal`
-- Data: None
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
