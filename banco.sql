-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.5.20 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.5.0.5272
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para progweb
CREATE DATABASE IF NOT EXISTS `progweb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `progweb`;

-- Copiando estrutura para tabela progweb.agendamento
CREATE TABLE IF NOT EXISTS `agendamento` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CPFALUNO` varchar(50) DEFAULT NULL,
  `SITUACAO` varchar(50) DEFAULT NULL,
  `CPFINSTRUTOR` int(11) DEFAULT NULL,
  `DATA` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela progweb.agendamento: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
INSERT INTO `agendamento` (`ID`, `CPFALUNO`, `SITUACAO`, `CPFINSTRUTOR`, `DATA`) VALUES
	(13, '01', 'Aguardando', 4, '2018-11-17 16:00:00'),
	(14, '01', 'Concluida', 2, '2018-09-12 14:00:00'),
	(15, '01', 'Concluida', 4, '2018-09-17 08:00:00'),
	(16, '01', 'Concluida', 2, '2018-09-17 10:00:00'),
	(17, '01', 'Aguardando', 3, '2018-11-12 16:00:00'),
	(18, '01', 'Aguardando', 2, '2018-11-15 16:00:00'),
	(19, '01', 'Aguardando', 4, '2018-11-10 16:00:00'),
	(20, '01', 'Aguardando', 4, '2018-11-13 16:00:00');
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;

-- Copiando estrutura para tabela progweb.carros
CREATE TABLE IF NOT EXISTS `carros` (
  `PLACA` varchar(50) NOT NULL,
  `MODELO` varchar(50) DEFAULT NULL,
  `MARCA` varchar(50) DEFAULT NULL,
  `ANO` int(11) DEFAULT NULL,
  PRIMARY KEY (`PLACA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela progweb.carros: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `carros` DISABLE KEYS */;
INSERT INTO `carros` (`PLACA`, `MODELO`, `MARCA`, `ANO`) VALUES
	('AAA', 'UNO', 'FIAT', 2015),
	('BBB', 'ONIX', 'CHEVROLET', 2015),
	('CCC', 'FIESTA', 'FORD', 2015),
	('DDD', 'GOL', 'VOLKSWAGEN', 2015),
	('QQQ-1212', 'Novo', 'Ford', 2001);
/*!40000 ALTER TABLE `carros` ENABLE KEYS */;

-- Copiando estrutura para tabela progweb.contato
CREATE TABLE IF NOT EXISTS `contato` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `CONTATO` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela progweb.contato: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` (`ID`, `NOME`, `EMAIL`, `CONTATO`) VALUES
	(1, 'eee', 'w@w.com', 'ksamdkamdkamsdkmsad');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;

-- Copiando estrutura para tabela progweb.pessoa
CREATE TABLE IF NOT EXISTS `pessoa` (
  `CPF` varchar(50) NOT NULL,
  `IMAGEM` varchar(50) DEFAULT NULL,
  `NOME` varchar(50) DEFAULT NULL,
  `RG` varchar(50) DEFAULT NULL,
  `SENHA` varchar(50) DEFAULT NULL,
  `DATANASCIMENTO` varchar(50) DEFAULT NULL,
  `TIPOCONTA` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CPF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela progweb.pessoa: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` (`CPF`, `IMAGEM`, `NOME`, `RG`, `SENHA`, `DATANASCIMENTO`, `TIPOCONTA`) VALUES
	('01', 'https://i.imgur.com/1LUGBd8.png', 'Arrascaeta', 'AR0123456789', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '2010-10-10', 'A'),
	('02', 'https://i.imgur.com/VZkiulo.png', 'Marco Aurelio', 'MA0123456789', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '1980-12-14', 'I'),
	('03', 'https://i.imgur.com/vc38zPX.png', 'Gustavo Garcia', 'GG0123456789', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '1996-02-11', 'I'),
	('04', 'https://i.imgur.com/5tUZxlg.png', 'João Gabriel', 'JG0123456789', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '1996-11-20', 'I');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
