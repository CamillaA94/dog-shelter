-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 27, 2022 alle 12:25
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
-- Database: `canile`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'gianluca', '123');

-- --------------------------------------------------------

--
-- Struttura della tabella `cani`
--

CREATE TABLE `cani` (
  `id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `razza` varchar(30) NOT NULL,
  `eta` int(11) NOT NULL,
  `sesso` varchar(1) NOT NULL,
  `sterilizzazione` tinyint(1) NOT NULL,
  `vaccinazioni` varchar(255) NOT NULL,
  `microchip` tinyint(1) NOT NULL,
  `descrizione` text NOT NULL,
  `arrivo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `cani`
--

INSERT INTO `cani` (`id`, `nome`, `razza`, `eta`, `sesso`, `sterilizzazione`, `vaccinazioni`, `microchip`, `descrizione`, `arrivo`) VALUES
(1, 'Nero', 'Alano', 6, 'M', 1, 'Parvovirus canino, Cimurro canino, Rabbia, Bordetella', 0, 'Dolce', '2022-12-15'),
(2, 'Fido', 'Pincher', 2, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia', 1, 'Piccolo', '2022-12-13'),
(3, 'Hachiko', 'Akita', 10, 'M', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia', 1, 'Affettuoso', '2022-12-01');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `cani`
--
ALTER TABLE `cani`
  ADD PRIMARY KEY (`id`),
  ADD KEY `microchip` (`microchip`),
  ADD KEY `sesso` (`sesso`),
  ADD KEY `steriliz` (`sterilizzazione`),
  ADD KEY `vaccino` (`vaccinazioni`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `cani`
--
ALTER TABLE `cani`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
