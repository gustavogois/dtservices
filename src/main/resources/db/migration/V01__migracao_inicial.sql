-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_ref_localidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_ref_localidade` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_ref_localidade` (
  `id` INT NOT NULL,
  `nome` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_ref_concelho`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_ref_concelho` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_ref_concelho` (
  `id` INT NOT NULL,
  `id_localidade` INT NOT NULL,
  `nome` VARCHAR(60) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_ref_concelho_tbl_ref_localidade1_idx` (`id_localidade` ASC),
  CONSTRAINT `fk_tbl_ref_concelho_tbl_ref_localidade1`
    FOREIGN KEY (`id_localidade`)
    REFERENCES `tbl_ref_localidade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_ref_distrito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_ref_distrito` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_ref_distrito` (
  `id` INT NOT NULL,
  `id_concelho` INT NOT NULL,
  `nome` VARCHAR(60) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_ref_distrito_tbl_ref_concelho1_idx` (`id_concelho` ASC),
  CONSTRAINT `fk_tbl_ref_distrito_tbl_ref_concelho1`
    FOREIGN KEY (`id_concelho`)
    REFERENCES `tbl_ref_concelho` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_endereco` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_endereco` (
  `id_imovel` BIGINT(4) NOT NULL,
  `id_distrito` INT NULL,
  `rua` VARCHAR(60) NULL,
  `complemento` VARCHAR(60) NULL,
  `codigo_postal` VARCHAR(9) NULL,
  `latitude` VARCHAR(15) NULL,
  `longitude` VARCHAR(15) NULL,
  `coord_x` VARCHAR(9) NULL,
  `coord_y` VARCHAR(9) NULL,
  `tbl_ref_distrito_id_distrito` INT NOT NULL,
  PRIMARY KEY (`id_imovel`),
  INDEX `fk_tbl_endereco_tbl_ref_distrito1_idx` (`id_distrito` ASC),
  CONSTRAINT `fk_tbl_endereco_tbl_ref_distrito1`
    FOREIGN KEY (`id_distrito`)
    REFERENCES `tbl_ref_distrito` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_imovel_tbl_endereco1`
    FOREIGN KEY (`id_imovel`)
    REFERENCES `tbl_imovel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_imovel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_imovel` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_imovel` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `crp` VARCHAR(60) NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_processo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_processo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_processo` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `id_imovel` BIGINT(4) NOT NULL,
  `cod_externo` VARCHAR(30) NOT NULL,
  `cod_interno` VARCHAR(9) NOT NULL,
  `dt_inicio` DATETIME(6) NULL,
  `dt_fim` DATETIME(6) NULL,
  `requisitante` VARCHAR(60) NULL,
  `com_chaves` TINYINT(1) NULL,
  `observacoes` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_processo_tbl_imovel_idx` (`id_imovel` ASC),
  CONSTRAINT `fk_tbl_processo_tbl_imovel`
    FOREIGN KEY (`id_imovel`)
    REFERENCES `tbl_imovel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_ref_tp_servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_ref_tp_servico` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_ref_tp_servico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NULL,
  `valor` DECIMAL(9,2) NULL,
  `descricao` VARCHAR(300) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_servico` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_servico` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `id_processo` BIGINT(4) NOT NULL,
  `id_tp_servico` INT NOT NULL,
  `valor` DECIMAL(9,2) NULL,
  `observacoes` VARCHAR(300) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_servico_tbl_processo1_idx` (`id_processo` ASC),
  INDEX `fk_tbl_servico_tbl_ref_tp_servico1_idx` (`id_tp_servico` ASC),
  CONSTRAINT `fk_tbl_servico_tbl_processo1`
    FOREIGN KEY (`id_processo`)
    REFERENCES `tbl_processo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_servico_tbl_ref_tp_servico1`
    FOREIGN KEY (`id_tp_servico`)
    REFERENCES `tbl_ref_tp_servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_ref_tipo_estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_ref_tipo_estado` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_ref_tipo_estado` (
  `id` INT NOT NULL,
  `categoria` VARCHAR(30) NULL,
  `nome` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_estado_servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_estado_servico` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_estado_servico` (
  `id` BIGINT(4) NOT NULL,
  `id_servico` BIGINT(4) NOT NULL,
  `id_tipo_estado` INT NOT NULL,
  `dt_inicio` DATETIME NULL,
  `dt_fim` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_estado_servico_tbl_servico1_idx` (`id_servico` ASC),
  INDEX `fk_tbl_estado_servico_tbl_ref_tipo_estado1_idx` (`id_tipo_estado` ASC),
  CONSTRAINT `fk_tbl_estado_servico_tbl_servico1`
    FOREIGN KEY (`id_servico`)
    REFERENCES `tbl_servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_estado_servico_tbl_ref_tipo_estado1`
    FOREIGN KEY (`id_tipo_estado`)
    REFERENCES `tbl_ref_tipo_estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_estado_processo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_estado_processo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_estado_processo` (
  `id` BIGINT(4) NOT NULL,
  `id_processo` BIGINT(4) NOT NULL,
  `id_tipo_estado` INT NOT NULL,
  `dt_inicio` DATETIME NULL,
  `dt_fim` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_estado_servico_tbl_ref_tipo_estado1_idx` (`id_tipo_estado` ASC),
  INDEX `fk_tbl_estado_processo_tbl_processo1_idx` (`id_processo` ASC),
  CONSTRAINT `fk_tbl_estado_servico_tbl_ref_tipo_estado10`
    FOREIGN KEY (`id_tipo_estado`)
    REFERENCES `tbl_ref_tipo_estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_estado_processo_tbl_processo1`
    FOREIGN KEY (`id_processo`)
    REFERENCES `tbl_processo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_ref_categoria_peca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_ref_categoria_peca` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_ref_categoria_peca` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_peca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_peca` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_peca` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_categoria_peca` INT NOT NULL,
  `nome` VARCHAR(60) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tbl_peca_tbl_ref_categoria_peca1_idx` (`id_categoria_peca` ASC),
  CONSTRAINT `fk_tbl_peca_tbl_ref_categoria_peca1`
    FOREIGN KEY (`id_categoria_peca`)
    REFERENCES `tbl_ref_categoria_peca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_peca_servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_peca_servico` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `tbl_peca_servico` (
  `id` BIGINT(4) NOT NULL AUTO_INCREMENT,
  `id_peca` INT NOT NULL,
  `id_servico` BIGINT(4) NOT NULL,
  INDEX `fk_tbl_peca_servico_tbl_peca1_idx` (`id_peca` ASC),
  INDEX `fk_tbl_peca_servico_tbl_servico1_idx` (`id_servico` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tbl_peca_servico_tbl_peca1`
    FOREIGN KEY (`id_peca`)
    REFERENCES `tbl_peca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tbl_peca_servico_tbl_servico1`
    FOREIGN KEY (`id_servico`)
    REFERENCES `tbl_servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `tbl_utilizador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tbl_utilizador` ;

SHOW WARNINGS;

CREATE TABLE tbl_utilizador (
	id BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SHOW WARNINGS;

DROP TABLE IF EXISTS `tbl_permissao` ;

-- -----------------------------------------------------
-- Table `tbl_permissao`
-- -----------------------------------------------------

SHOW WARNINGS;

CREATE TABLE tbl_permissao (
	id BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SHOW WARNINGS;

DROP TABLE IF EXISTS `tbl_utilizador_permissao` ;

-- -----------------------------------------------------
-- Table `tbl_utilizador_permissao`
-- -----------------------------------------------------

SHOW WARNINGS;

CREATE TABLE tbl_utilizador_permissao (
	id_usuario BIGINT(20) NOT NULL,
	id_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (id_usuario, id_permissao),
	FOREIGN KEY (id_usuario) REFERENCES tbl_utilizador(id),
	FOREIGN KEY (id_permissao) REFERENCES tbl_permissao(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
