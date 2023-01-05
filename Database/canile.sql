-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 05, 2023 alle 09:12
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
(1, 'Jack', 'Labrador retriever', 2, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina, Vaccino di Lyme', 1, 'Solare, pieno di vita e affettuoso con tutti', '2022-10-14'),
(2, 'Aki', 'Siberian Husky', 7, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina', 1, 'Esuberante e allegro. Patisce moltissimo la reclusione e la solitudine in canile, ha bisogno di una figura di riferimento che gli trasmetta affetto e sicurezza', '2022-03-12'),
(3, 'Stella', 'American staffordshire terrier', 4, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina, Vaccino di Lyme, Leishmania', 1, 'Timorosa e docile. Ha subito maltrattamenti e ha bisogno di tempo per instaurare un legame di fiducia', '2021-06-17'),
(4, 'Rocky', 'Beagle', 9, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Leishmania', 1, 'Socievole e giocherellone con le persone, tende ad essere aggressivo con gli altri animali', '2017-03-02'),
(5, 'Bianca', 'Labrador retriever', 5, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina, Vaccino di Lyme, Leishmania', 1, 'Piena di energie, equilibrata e socievole con le persone', '2022-02-10'),
(6, 'Argo', 'Bulldog inglese', 7, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Influenza canina, Leishmania', 1, 'Amante delle coccole e delle passeggiate, diventa dolcissimo con chi riesce ad ottenere la sua fiducia', '2018-11-15'),
(7, 'Olly', 'Border collie', 5, 'F', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Leishmania', 1, 'Timida e molto selettiva con le persone, ha bisogno di qualcuno che sappia gestire le sue paure e rispettare i suoi tempi', '2019-03-07'),
(8, 'Kiko', 'Bracco tedesco', 3, 'M', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Vaccino di Lyme', 1, 'Giocoso, socievole e molto geloso dei suoi spazi. Ha una leggera zoppia dovuta ai maltrattamenti subiti', '2021-04-15'),
(9, 'Jamal', 'Cavalier king charles spaniel', 1, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina', 1, 'Vivace e ribelle. Ha completamente perso la vista all\'occhio sinistro in seguito a un incidente', '2018-06-19'),
(10, 'Zeus', 'Golden retriever', 1, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Influenza canina, Vaccino di Lyme, Leishmania', 1, 'Affettuoso e calmo. Soffre di una lieve forma di displasia dell\'anca', '2020-06-20'),
(11, 'Jason', 'Meticcio', 6, 'M', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Vaccino di Lyme, Leishmania', 1, 'Vivace e goloso. Soffre di epilessia ereditaria', '2021-08-02'),
(12, 'Diana', 'Bulldog francese', 2, 'F', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Vaccino di Lyme, Leishmania', 0, 'Insicura e schiva, ha passato quasi tutta la vita in canile e ha bisogno di qualcuno che gli doni cure e affetto', '2015-01-20'),
(13, 'Ruby', 'Meticcio', 4, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina, Vaccino di Lyme, Leishmania', 1, 'Atletica e giocherellona, ama la compagnia degli altri cani', '2022-06-22'),
(14, 'Leo', 'Meticcio', 1, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina', 1, 'Timido e molto pigro, ma in grado di donare tantissimo affetto', '2019-09-16'),
(15, 'Joy', 'Pitbull terrier', 5, 'F', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina, Vaccino di Lyme, Leishmania', 1, 'Piena di energia, vivace, giocherellona e socievole', '2022-09-08'),
(16, 'Zoe', 'Labrador retriever', 1, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Leishmania', 1, 'Schiva e timorosa, ha bisogno di coccole e carezze per iniziare a fidarsi delle persone', '2021-12-14'),
(17, 'Rio', 'Meticcio', 8, 'M', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella', 1, 'Affettuoso, dolce e giocherellone', '2022-05-11'),
(18, 'Laika', 'Kooikerhondje', 5, 'F', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina', 1, 'Ama il contatto umano e la compagnia di altri animali. Soffre di alcune intolleranze alimentari', '2017-06-13'),
(19, 'Matilde', 'Meticcio', 8, 'F', 0, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Influenza canina', 1, 'Una delle nostre ospiti più anziane,ma non per questo poco affettuosa. ', '2022-03-09'),
(20, 'Oliver', 'Border collie', 6, 'M', 1, 'Parvovirus canino, Cimurro canino, Epatite, Leptospirosi, Rabbia, Bordetella, Leishmania', 1, 'Docile e in cerca di cura e attenzioni. Soffre della Sindrome di Cushing', '2019-11-18'),
(21, 'Skipper', 'Meticcio', 11, 'F', 1, 'Rabbia', 1, 'Femmina timidina di circa 7 mesi. Sarà una futura taglia media contenuta. Bea è davvero molto carina, sfortunatamente è un pò timida nei rapporti con le persone ma non ci fermiamo davanti alla timidezza di una cagnolina.', '2020-01-02'),
(22, 'Hope', 'Meticcio', 6, 'F', 1, 'Rabbia', 1, 'Hope ha un carattere strepitoso nonostante la vita non le abbia riservato un bel trattamento. Ora è al sicuro da noi ma purtroppo , all\'inizio dell\'anno, mentre girovagava abbandonata per le campagne, ha subito un brutto incidente e ha di conseguenza perso l\'occhio destro.', '2022-12-05'),
(23, 'Troy', 'Dogo argentino', 5, 'M', 0, 'Rabbia', 1, 'Per lui cerchiamo un\'adozione consapevole e molto ponderata da parte di persone esperte nel trattare questa tipologia di cani , Troy è buono e docile  ma come tutti i cani della sua razza è una forza della natura. ', '2022-08-24');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
