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
-- Base de données :  `ebanking`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonne`
--

DROP TABLE IF EXISTS `abonne`;
CREATE TABLE IF NOT EXISTS `abonne` (
  `idClient` varchar(8) NOT NULL,
  `codeAbonne` varchar(60) NOT NULL,
  `passwordAbonne` varchar(60) NOT NULL,
  `dateCreation` date NOT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `codeAbonne_UNIQUE` (`codeAbonne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `abonne`
--

INSERT INTO `abonne` (`idClient`, `codeAbonne`, `passwordAbonne`, `dateCreation`) VALUES
('BFI12345', 'abonne1', '$2a$04$DfK5sGJ7FJdFkM4P/iKpWOg.gzg4wPbKQDz6NKL4Ev1c68OcN0DwK', '2018-04-07'),
('BFI34567', 'abonne3', '$2a$04$JzgWGVxltLZMKZfpD/6Sr.vu9I6PsnonJe/PdSFHTv6jmkKbtN5zi', '2018-03-17'),
('BFI56789', 'abonne2', '$2a$04$ITT6FIuqlm/cBhriYyish.8Pnh9iILrlgDs0pMxx1Bb13MrgurF5W', '2018-04-01'),
('BFI72534', 'abonne4', '$2a$04$RWegMIvZm2A94m4CAupD..hiCaWXVKQ9XVck8d68NYo8pdsGPbbRu', '2018-04-22');

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `idAdministrateur` varchar(8) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`idAdministrateur`),
  KEY `idAdministrateur` (`idAdministrateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`idAdministrateur`, `username`, `password`) VALUES
('BFIAD123', 'admin1', '$2a$04$uo/5bXgQ6qflZ7J4wFYEwuHqrd1FjfnoHWcupj2Nhd6vW3FHgZ7jW'),
('BFIAD456', 'admin2', '$2a$04$0zWt.urKBGgyX/s4JBW1Hu6d6PfaRRkgDnORq8WzFMyLRc5woJAJS');

-- --------------------------------------------------------

--
-- Structure de la table `beneficiaire`
--

DROP TABLE IF EXISTS `beneficiaire`;
CREATE TABLE IF NOT EXISTS `beneficiaire` (
  `idBeneficiaire` int(11) NOT NULL AUTO_INCREMENT,
  `RIB` varchar(60) NOT NULL,
  `nom` varchar(60) NOT NULL,
  `prenom` varchar(60) NOT NULL,
  `statut` varchar(45) NOT NULL,
  `codeValidation` varchar(11) NOT NULL,
  `idClient` varchar(8) NOT NULL,
  PRIMARY KEY (`idBeneficiaire`,`idClient`),
  UNIQUE KEY `numeroCompte_UNIQUE` (`RIB`),
  KEY `fk_Beneficiaire_Abonne_idx` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `beneficiaire`
--

INSERT INTO `beneficiaire` (`idBeneficiaire`, `RIB`, `nom`, `prenom`, `statut`, `codeValidation`, `idClient`) VALUES
(1, '30002005520000156739587', 'Chagwey', 'Haythem', 'Valide', 'Cv0khCPzkT5', 'BFI12345'),
(2, '30002005500000016736801', 'Chbil', 'Hamza', 'Valide', 'Cv0khCPzkT5', 'BFI12345'),
(3, '30002005500000153896062', 'Khammassi', 'Ayoub', 'Valide', 'u3rE4kn6EF2', 'BFI12345');

-- --------------------------------------------------------

--
-- Structure de la table `demandevirementbancaire`
--

DROP TABLE IF EXISTS `demandevirementbancaire`;
CREATE TABLE IF NOT EXISTS `demandevirementbancaire` (
  `idDemandeVirementBancaire` int(11) NOT NULL AUTO_INCREMENT,
  `RIBexpediteur` varchar(60) NOT NULL,
  `RIBdestinataire` varchar(60) NOT NULL,
  `montant` double NOT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `statut` varchar(45) NOT NULL,
  `dateVirement` date NOT NULL,
  `idClient` varchar(8) NOT NULL,
  `idBeneficiaire` int(11) DEFAULT NULL,
  `nomDestinataire` varchar(60) DEFAULT NULL,
  `prenomDestinataire` varchar(60) DEFAULT NULL,
  `typeVirement` varchar(60) NOT NULL,
  PRIMARY KEY (`idDemandeVirementBancaire`) USING BTREE,
  KEY `fk_DemandeVirementInterBancaire_Abonne1_idx` (`idClient`),
  KEY `fk_DemandeVirementInterBancaire_Beneficiaire1_idx` (`idBeneficiaire`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `demandevirementbancaire`
--

INSERT INTO `demandevirementbancaire` (`idDemandeVirementBancaire`, `RIBexpediteur`, `RIBdestinataire`, `montant`, `motif`, `statut`, `dateVirement`, `idClient`, `idBeneficiaire`, `nomDestinataire`, `prenomDestinataire`, `typeVirement`) VALUES
(1, '30004000031234567890143', '30002005500000157076207', 25.5, 'Cadeau pour Marzouki', 'non confirme', '2018-04-06', 'BFI12345', 1, 'Marzouki', 'Melek', 'Inter'),
(2, '30004015870002601171220', '30002005500000157076207', 30, 'Salaire pour Missaoui', 'confirme', '2018-04-09', 'BFI56789', 3, 'Missaoui', 'Mohamed', 'Inter'),
(3, '30004000031234567890143', '30002005500000156334836', 40.25, NULL, 'confirme', '2018-04-17', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(6, '30004000031234567890143', '30002005500000157841343', 50.2, NULL, 'confirme', '2018-04-23', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(7, '30002005520000156739587', '30004000031234567890143', 200, NULL, 'non confirme', '2018-04-23', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(8, '30004000031234567890143', '30002005500000157841343', 300, NULL, 'non confirme', '2018-04-23', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(16, '30004000031234567890143', '30002005500000157841343', 500, NULL, 'non confirme', '2018-04-25', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(17, '30004000031234567890143', '30002005500000157841343', 1000, NULL, 'non confirme', '2018-04-29', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(18, '30004000031234567890143', '30004000031234567890143', 400, NULL, 'non confirme', '2018-04-29', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(57, '30004000031234567890143', '30002005500000157841343', 200, NULL, 'non confirme', '2018-05-02', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(58, '30004000031234567890143', '30002005500000157841343', 6, NULL, 'non confirme', '2018-05-02', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(59, '30004000031234567890143', '30002005500000157841343', 300, NULL, 'non confirme', '2018-05-03', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(76, '30004000031234567890143', '30004000031234567890143', 200, NULL, 'non confirme', '2018-05-04', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(77, '30004000031234567890143', '30004000031234567890143', 555, NULL, 'non confirme', '2018-05-04', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(78, '30004000031234567890143', '30002005520000156739587', 100, 'Paiement', 'confirme', '2018-05-04', 'BFI12345', 2, 'Chbil', 'Hamza', 'Inter'),
(79, '30002005500000157841343', '30004000031234567890143', 200, NULL, 'non confirme', '2018-05-06', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(80, '30002005500000157841343', '30002005520000156739587', 200, 'Paiement', 'confirme', '2018-05-07', 'BFI12345', 1, 'Chagwey', 'Haythem', 'Inter'),
(81, '30002005500000157841343', '30004000031234567890143', 100, NULL, 'confirme', '2018-05-07', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(82, '30002005500000157841343', '30004000031234567890143', 300, NULL, 'non confirme', '2018-05-11', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(83, '30002005500000157841343', '30004000031234567890143', 350, NULL, 'non confirme', '2018-05-11', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(84, '30004000031234567890143', '30002005500000157841343', 100, NULL, 'non confirme', '2018-05-11', 'BFI12345', NULL, NULL, NULL, 'Intra'),
(85, '30002005500000157841343', '30002005520000156739587', 100, 'Paiement', 'non confirme', '2018-05-11', 'BFI12345', 1, 'Chagwey', 'Haythem', 'Inter');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `beneficiaire`
--
ALTER TABLE `beneficiaire`
  ADD CONSTRAINT `fk_Beneficiaire_Abonne` FOREIGN KEY (`idClient`) REFERENCES `abonne` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `demandevirementbancaire`
--
ALTER TABLE `demandevirementbancaire`
  ADD CONSTRAINT `demandevirementbancaire_ibfk_1` FOREIGN KEY (`idBeneficiaire`) REFERENCES `beneficiaire` (`idBeneficiaire`),
  ADD CONSTRAINT `fk_DemandeVirementBancaire_Abonne1` FOREIGN KEY (`idClient`) REFERENCES `abonne` (`idClient`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
