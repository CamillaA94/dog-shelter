-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 19, 2022 alle 15:47
-- Versione del server: 10.4.25-MariaDB
-- Versione PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pj_canile`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `anagrafica_cani`
--

CREATE TABLE `anagrafica_cani` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `razza` varchar(15) DEFAULT NULL,
  `eta` int(11) DEFAULT NULL,
  `sesso` varchar(1) NOT NULL,
  `sterilizzazione` tinyint(1) DEFAULT NULL,
  `stato_vaccinale` int(11) DEFAULT NULL,
  `mircrochip` tinyint(1) DEFAULT NULL,
  `descrizione_varie` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `profilo`
--

CREATE TABLE `profilo` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `anagrafica_cani`
--
ALTER TABLE `anagrafica_cani`
  ADD PRIMARY KEY (`id`),
  ADD KEY `microchip` (`mircrochip`),
  ADD KEY `sesso` (`sesso`),
  ADD KEY `steriliz` (`sterilizzazione`),
  ADD KEY `vaccino` (`stato_vaccinale`);

--
-- Indici per le tabelle `profilo`
--
ALTER TABLE `profilo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `anagrafica_cani`
--
ALTER TABLE `anagrafica_cani`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `profilo`
--
ALTER TABLE `profilo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
