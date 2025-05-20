-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 18/04/2019 às 19:27
-- Versão do servidor: 5.7.25-0ubuntu0.18.04.2
-- Versão do PHP: 7.2.15-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `consultorio`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `consultas`
--

CREATE TABLE `consultas` (
  `ID_consulta` int(11) NOT NULL,
  `id_medico` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `compareceu` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `consultas`
--

INSERT INTO `consultas` (`ID_consulta`, `id_medico`, `id_paciente`, `data`, `hora`, `compareceu`) VALUES
(1, 1, 1, '2012-06-12', '14:00:00', '1'),
(2, 2, 2, '2012-06-12', '14:30:00', '0'),
(3, 1, 3, '2012-06-11', '15:30:00', '1'),
(4, 2, 5, '2012-06-12', '13:00:00', '1'),
(5, 3, 6, '2012-06-12', '16:00:00', '1'),
(6, 2, 7, '2012-06-14', '16:30:00', '1'),
(7, 3, 7, '2012-06-13', '17:00:00', '0'),
(8, 4, 8, '2012-06-13', '17:30:00', '1'),
(9, 3, 9, '2012-06-13', '14:30:00', '1'),
(10, 1, 2, '2012-06-11', '14:00:00', '1'),
(11, 3, 4, '2012-06-11', '15:00:00', '1'),
(12, 5, 5, '2012-06-15', '15:30:00', '1'),
(13, 2, 6, '2012-06-15', '13:30:00', '1'),
(14, 3, 6, '2012-06-14', '16:30:00', '1'),
(15, 4, 9, '2012-06-15', '17:00:00', '1'),
(16, 2, 3, '2012-06-15', '14:00:00', '1'),
(17, 5, 3, '2012-06-15', '13:00:00', '1'),
(18, 4, 8, '2012-06-25', '14:00:00', '0'),
(19, 2, 3, '2012-06-26', '15:00:00', '0'),
(20, 1, 5, '2012-06-26', '18:00:00', '0'),
(21, 1, 3, '2012-06-29', '17:00:00', '0'),
(22, 5, 1, '2012-07-03', '17:30:00', '0'),
(23, 5, 7, '2012-07-04', '14:00:00', '0'),
(24, 2, 4, '2012-07-03', '16:00:00', '0'),
(25, 3, 8, '2012-07-03', '16:30:00', '0');

-- --------------------------------------------------------

--
-- Estrutura para tabela `medicos`
--

CREATE TABLE `medicos` (
  `id` int(11) NOT NULL,
  `nome_med` varchar(100) NOT NULL,
  `especialidade` varchar(20) NOT NULL,
  `data_nasc` date DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `fone` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `medicos`
--

INSERT INTO `medicos` (`id`, `nome_med`, `especialidade`, `data_nasc`, `sexo`, `fone`) VALUES
(1, 'Carlos Chagas', 'Clínico Geral', '1979-04-30', 'm', '562525'),
(2, 'Lucas de Oliveira', 'Oftalmologista', '1981-05-02', 'm', '645656'),
(3, 'Marina Silva', 'Dermatologista', '1982-08-10', 'f', '465666'),
(4, 'Simone Flores', 'Ginecologista', '1983-10-27', 'f', '344562'),
(5, 'Laura Freitas', 'Clínico Geral', '1980-11-04', 'f', '686834');

-- --------------------------------------------------------

--
-- Estrutura para tabela `pacientes`
--

CREATE TABLE `pacientes` (
  `codigo` int(11) NOT NULL,
  `nome_pac` varchar(100) NOT NULL,
  `fone` varchar(10) NOT NULL,
  `data_nasc` date NOT NULL,
  `sexo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `pacientes`
--

INSERT INTO `pacientes` (`codigo`, `nome_pac`, `fone`, `data_nasc`, `sexo`) VALUES
(1, 'Ana Souza', '1234555', '2000-05-29', 'f'),
(2, 'Laiz Souto', '7657456', '2002-06-23', 'f'),
(3, 'Leandro Castro', '1555234', '2004-07-11', 'm'),
(4, 'Fernanda Farias', '3451255', '1999-05-03', 'f'),
(5, 'Naldo Cortes', '5445345', '1998-10-13', 'm'),
(6, 'Lucy Bella', '7865388', '1978-05-06', 'f'),
(7, 'Mauro Lopes', '3664567', '1997-06-25', 'm'),
(8, 'Bianca Mattos', '5764576', '1997-02-18', 'f'),
(9, 'Jorge Mota', '7643654', '1985-03-16', 'm'),
(10, 'Carla Rocha', '5623546', '1987-01-27', 'f');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`ID_consulta`),
  ADD KEY `id_medico` (`id_medico`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Índices de tabela `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `consultas`
--
ALTER TABLE `consultas`
  MODIFY `ID_consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT de tabela `medicos`
--
ALTER TABLE `medicos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de tabela `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `consultas`
--
ALTER TABLE `consultas`
  ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`id_medico`) REFERENCES `medicos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
