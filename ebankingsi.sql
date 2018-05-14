-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 14 mai 2018 à 12:16
-- Version du serveur :  5.7.19-log
-- Version de PHP :  7.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ebankingsi`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` varchar(8) NOT NULL,
  `dateDeNaissance` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `sexe` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `dateDeNaissance`, `email`, `nom`, `prenom`, `sexe`, `telephone`) VALUES
('BFI12345', '1996-04-29', 'missaoui.sadek@gmail.com', 'Missaoui', 'Sadek', 'M', '55266386'),
('BFI16483', '1993-05-11', 'nom1.prenom1@gmail.com', 'nomm', 'prenomm', 'F', '12345678'),
('BFI34567', '1980-01-01', 'sbessi@gmail.com', 'Bassi', 'Selim', 'M', '58607132'),
('BFI56789', '1996-05-13', 'achref_haouech@hotmail.com', 'Haouech', 'Achref', 'F', '55552757'),
('BFI72534', '1991-01-04', 'nom2-prenom2@email.com', 'nom', 'prenom', 'M', '98765432');

-- --------------------------------------------------------

--
-- Structure de la table `cmdcarte`
--

DROP TABLE IF EXISTS `cmdcarte`;
CREATE TABLE IF NOT EXISTS `cmdcarte` (
  `idCmdCarte` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(60) NOT NULL,
  `statut` varchar(60) NOT NULL,
  `RIB` varchar(60) NOT NULL,
  `idClient` varchar(8) NOT NULL,
  PRIMARY KEY (`idCmdCarte`),
  KEY `idClient` (`idClient`),
  KEY `cmdcarte_ibfk_2` (`RIB`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cmdcarte`
--

INSERT INTO `cmdcarte` (`idCmdCarte`, `type`, `statut`, `RIB`, `idClient`) VALUES
(1, 'Gold', 'disponible', '30004000031234567890143', 'BFI12345'),
(2, 'Platinum', 'disponible', '30002005500000157841343', 'BFI12345'),
(4, 'Premier', 'en cours d\'impression', '30004000031234567890143', 'BFI12345'),
(18, 'Platinum', 'en cours d\'impression', '30002005500000157841343', 'BFI12345');

-- --------------------------------------------------------

--
-- Structure de la table `cmdchequier`
--

DROP TABLE IF EXISTS `cmdchequier`;
CREATE TABLE IF NOT EXISTS `cmdchequier` (
  `idCmdChequier` int(11) NOT NULL AUTO_INCREMENT,
  `statut` varchar(45) NOT NULL,
  `nombre` int(11) NOT NULL,
  `idClient` varchar(8) NOT NULL,
  `RIB` varchar(60) NOT NULL,
  PRIMARY KEY (`idCmdChequier`),
  KEY `Abonne_idClient` (`idClient`),
  KEY `cmdchequier_ibfk_2` (`RIB`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cmdchequier`
--

INSERT INTO `cmdchequier` (`idCmdChequier`, `statut`, `nombre`, `idClient`, `RIB`) VALUES
(1, 'disponible', 25, 'BFI12345', '30004000031234567890143'),
(2, 'disponible', 50, 'BFI12345', '30002005500000157841343'),
(5, 'en cours d\'impression', 25, 'BFI12345', '30002005500000157841343'),
(12, 'en cours d\'impression', 25, 'BFI12345', '30004000031234567890143');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `RIB` varchar(60) NOT NULL,
  `dateCreation` datetime NOT NULL,
  `idClient` varchar(8) NOT NULL,
  `solde` double NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`RIB`),
  UNIQUE KEY `RIB` (`RIB`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`RIB`, `dateCreation`, `idClient`, `solde`, `type`) VALUES
('30002005500000156334836', '2018-04-05 00:00:00', 'BFI72534', 200, 'courant'),
('30002005500000157076207', '2018-04-05 00:00:00', 'BFI34567', 1000, 'courant'),
('30002005500000157324527', '2018-04-05 00:00:00', 'BFI16483', 500, 'indivis'),
('30002005500000157841343', '2018-04-05 00:00:00', 'BFI12345', 1611, 'épargne'),
('30004000031234567890143', '2018-04-05 00:00:00', 'BFI12345', 1187, 'courant'),
('30004015870002601171220', '2018-04-05 00:00:00', 'BFI56789', 1630.5, 'courant');

-- --------------------------------------------------------

--
-- Structure de la table `operation`
--

DROP TABLE IF EXISTS `operation`;
CREATE TABLE IF NOT EXISTS `operation` (
  `idOperation` int(11) NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `dateOperation` date NOT NULL,
  `RIB` varchar(60) NOT NULL,
  `valeur` double NOT NULL,
  PRIMARY KEY (`idOperation`),
  KEY `operation_ibfk_1` (`RIB`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `operation`
--

INSERT INTO `operation` (`idOperation`, `description`, `dateOperation`, `RIB`, `valeur`) VALUES
(1, 'Dépôt', '2018-04-23', '30004000031234567890143', 500),
(2, 'Retrait', '2018-04-16', '30004015870002601171220', -200),
(3, 'Retrait', '2018-04-28', '30004000031234567890143', -300),
(8, 'Virement intraBancaire de 30004000031234567890143', '2018-04-29', '30002005500000157841343', 1000),
(9, 'Virement intraBancaire a 30002005500000157841343', '2018-04-29', '30004000031234567890143', -1000),
(10, 'Virement intraBancaire a 30004000031234567890143', '2018-04-29', '30002005500000157841343', -400),
(11, 'Virement intraBancaire de 30002005500000157841343', '2018-04-29', '30004000031234567890143', 400),
(12, 'Virement intraBancaire de 30004000031234567890143', '2018-05-02', '30002005500000157841343', 200),
(13, 'Virement intraBancaire a 30002005500000157841343', '2018-05-02', '30004000031234567890143', -200),
(14, 'Virement intraBancaire a 30002005500000157841343', '2018-05-02', '30004000031234567890143', -6),
(15, 'Virement intraBancaire de 30004000031234567890143', '2018-05-02', '30002005500000157841343', 6),
(16, 'Virement intraBancaire de 30004000031234567890143', '2018-05-03', '30002005500000157841343', 300),
(17, 'Virement intraBancaire a 30002005500000157841343', '2018-05-03', '30004000031234567890143', -300),
(20, 'Virement interBancaire a 30002005520000156739587', '2018-05-03', '30004000031234567890143', -300),
(23, 'Virement interBancaire a 30002005520000156739587', '2018-05-03', '30004000031234567890143', -200),
(25, 'Virement interBancaire a 30002005520000156739587', '2018-05-03', '30004000031234567890143', -100),
(26, 'Virement interBancaire a 30002005520000156739587', '2018-05-03', '30004000031234567890143', -50),
(27, 'Virement interBancaire a 30002005520000156739587', '2018-05-04', '30004000031234567890143', -50),
(29, 'Virement intraBancaire de 30002005500000157841343', '2018-05-04', '30004000031234567890143', 200),
(30, 'Virement intraBancaire a 30004000031234567890143', '2018-05-04', '30002005500000157841343', -200),
(31, 'Virement intraBancaire de 30004000031234567890143', '2018-05-04', '30002005500000157841343', 555),
(32, 'Virement intraBancaire a 30002005500000157841343', '2018-05-04', '30004000031234567890143', -555),
(33, 'Virement interBancaire a 30002005500000157841343', '2018-05-04', '30004000031234567890143', -100),
(34, 'Virement intraBancaire de 30002005500000157841343', '2018-05-06', '30004000031234567890143', 200),
(35, 'Virement intraBancaire a 30004000031234567890143', '2018-05-06', '30002005500000157841343', -200),
(36, 'Virement interBancaire a 30002005520000156739587', '2018-05-07', '30002005500000157841343', -200),
(37, 'Virement intraBancaire de 30002005500000157841343', '2018-05-07', '30004000031234567890143', 100),
(38, 'Virement intraBancaire a 30004000031234567890143', '2018-05-07', '30002005500000157841343', -100),
(39, 'Virement intraBancaire de 30002005500000157841343', '2018-05-11', '30004000031234567890143', 300),
(40, 'Virement intraBancaire a 30004000031234567890143', '2018-05-11', '30002005500000157841343', -300),
(41, 'Virement intraBancaire a 30004000031234567890143', '2018-05-11', '30002005500000157841343', -350),
(42, 'Virement intraBancaire de 30002005500000157841343', '2018-05-11', '30004000031234567890143', 350),
(43, 'Virement intraBancaire a 30002005500000157841343', '2018-05-11', '30004000031234567890143', -100),
(44, 'Virement intraBancaire de 30004000031234567890143', '2018-05-11', '30002005500000157841343', 100),
(45, 'Virement interBancaire a 30002005520000156739587', '2018-05-11', '30002005500000157841343', -100);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cmdcarte`
--
ALTER TABLE `cmdcarte`
  ADD CONSTRAINT `cmdcarte_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `cmdcarte_ibfk_2` FOREIGN KEY (`RIB`) REFERENCES `compte` (`RIB`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `cmdchequier`
--
ALTER TABLE `cmdchequier`
  ADD CONSTRAINT `cmdchequier_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  ADD CONSTRAINT `cmdchequier_ibfk_2` FOREIGN KEY (`RIB`) REFERENCES `compte` (`RIB`) ON UPDATE CASCADE;

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `operation`
--
ALTER TABLE `operation`
  ADD CONSTRAINT `operation_ibfk_1` FOREIGN KEY (`RIB`) REFERENCES `compte` (`RIB`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
