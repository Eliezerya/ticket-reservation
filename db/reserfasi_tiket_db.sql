-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2022 at 04:57 PM
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
-- Table structure for table `films`
--

CREATE TABLE `films` (
  `film_code` int(11) NOT NULL,
  `film_name` varchar(255) DEFAULT NULL,
  `film_status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`film_code`, `film_name`, `film_status`) VALUES
(1, 'nya', b'1'),
(2, 'neko', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `master_studio`
--

CREATE TABLE `master_studio` (
  `id_studio` int(11) NOT NULL,
  `no_seat` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `studio` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `master_studio`
--

INSERT INTO `master_studio` (`id_studio`, `no_seat`, `status`, `studio`) VALUES
(1, 1, b'1', 'A'),
(2, 2, b'1', 'A'),
(3, 1, b'1', 'B'),
(4, 1, b'1', 'A'),
(5, 1, b'0', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `schedule_id` int(11) NOT NULL,
  `harga_tiket` bigint(20) DEFAULT NULL,
  `mulai_tayang` datetime DEFAULT NULL,
  `selesai_tayang` datetime DEFAULT NULL,
  `code_films` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`schedule_id`, `harga_tiket`, `mulai_tayang`, `selesai_tayang`, `code_films`) VALUES
(1, 20000, '2022-04-02 00:00:00', '2022-04-03 00:00:00', 1),
(2, 99000, '2022-12-02 00:01:00', '2022-12-02 00:02:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `seats`
--

CREATE TABLE `seats` (
  `schedule_id` int(11) NOT NULL,
  `film_code` int(11) NOT NULL,
  `name_studio` varchar(255) DEFAULT NULL,
  `no_kursi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seats`
--

INSERT INTO `seats` (`schedule_id`, `film_code`, `name_studio`, `no_kursi`) VALUES
(1, 1, 'A', 1),
(2, 2, 'A', 5);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_users` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_users`, `email`, `password`, `username`) VALUES
(1, 'andeliezer99@gmail.com', 'nyaaasd', 'eli');

-- --------------------------------------------------------

--
-- Stand-in structure for view `vw_jadwal`
-- (See below for the actual view)
--
CREATE TABLE `vw_jadwal` (
`id_jadwal` int(11)
,`selesai_tayang` datetime
,`film_name` varchar(255)
,`code_films` int(11)
,`harga_tiket` bigint(20)
);

-- --------------------------------------------------------

--
-- Structure for view `vw_jadwal`
--
DROP TABLE IF EXISTS `vw_jadwal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_jadwal`  AS SELECT `jadwal`.`schedule_id` AS `id_jadwal`, `jadwal`.`selesai_tayang` AS `selesai_tayang`, `film`.`film_name` AS `film_name`, `jadwal`.`code_films` AS `code_films`, `jadwal`.`harga_tiket` AS `harga_tiket` FROM ((`films` `film` join `schedules` `jadwal` on(`jadwal`.`code_films` = `film`.`film_code`)) join `seats` `studio` on(`studio`.`schedule_id` = `jadwal`.`code_films`)) WHERE `film`.`film_status` = 1 ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `films`
--
ALTER TABLE `films`
  ADD PRIMARY KEY (`film_code`);

--
-- Indexes for table `master_studio`
--
ALTER TABLE `master_studio`
  ADD PRIMARY KEY (`id_studio`);

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `FK6wwxkul7atr2stecmsmkynggp` (`code_films`);

--
-- Indexes for table `seats`
--
ALTER TABLE `seats`
  ADD PRIMARY KEY (`schedule_id`,`film_code`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_users`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `films`
--
ALTER TABLE `films`
  MODIFY `film_code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `master_studio`
--
ALTER TABLE `master_studio`
  MODIFY `id_studio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_users` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `FK6wwxkul7atr2stecmsmkynggp` FOREIGN KEY (`code_films`) REFERENCES `films` (`film_code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
