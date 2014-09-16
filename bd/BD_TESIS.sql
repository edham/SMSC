-- MySQL Script generated by MySQL Workbench
-- 07/31/14 21:33:02
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SMSC_BD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SMSC_BD` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SMSC_BD` ;

-- -----------------------------------------------------
-- Table `SMSC_BD`.`tipo_personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`tipo_personal` (
  `id_tipo_personal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_tipo_personal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`departamento` (
  `id_departamento` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_departamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`provincia` (
  `id_provincia` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `id_departamento` INT NOT NULL,
  PRIMARY KEY (`id_provincia`),
  INDEX `fk_provincia_departamento1_idx` (`id_departamento` ASC),
  CONSTRAINT `fk_provincia_departamento1`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `SMSC_BD`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`distrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`distrito` (
  `id_distrito` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `id_provincia` INT NOT NULL,
  PRIMARY KEY (`id_distrito`),
  INDEX `fk_distrito_provincia1_idx` (`id_provincia` ASC),
  CONSTRAINT `fk_distrito_provincia1`
    FOREIGN KEY (`id_provincia`)
    REFERENCES `SMSC_BD`.`provincia` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`personal` (
  `id_personal` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_personal` INT NOT NULL,
  `id_distrito` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido_paterno` VARCHAR(45) NOT NULL,
  `apellido_materno` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(10) NULL,
  `celular` VARCHAR(9) NULL,
  `email` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(8) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longuitud` DOUBLE NOT NULL,
  `puntos` INT NOT NULL,
  `foto` BLOB NULL,
  `fecha_registro` DATETIME NOT NULL,
  `fecha_actualizacion` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_personal`),
  INDEX `fk_personal_tipo_personal_idx` (`id_tipo_personal` ASC),
  INDEX `fk_personal_distrito1_idx` (`id_distrito` ASC),
  CONSTRAINT `fk_personal_tipo_personal`
    FOREIGN KEY (`id_tipo_personal`)
    REFERENCES `SMSC_BD`.`tipo_personal` (`id_tipo_personal`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_personal_distrito1`
    FOREIGN KEY (`id_distrito`)
    REFERENCES `SMSC_BD`.`distrito` (`id_distrito`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido_paterno` VARCHAR(45) NOT NULL,
  `apellido_materno` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `celular` VARCHAR(9) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `sexo` BIT NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `fecha_registro` DATETIME NOT NULL,
  `cantidad_falso` INT NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`vehiculo` (
  `id_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  `fecha_registro` DATETIME NOT NULL,
  `fecha_actualizacion` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_vehiculo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`personal_vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`personal_vehiculo` (
  `id_personal_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `id_vehiculo` INT NOT NULL,
  `id_personal` INT NOT NULL,
  `fecha_entrada` DATETIME NOT NULL,
  `fecha_salida` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_personal_vehiculo`),
  INDEX `fk_usuario_vehiculo_vehiculo1_idx` (`id_vehiculo` ASC),
  INDEX `fk_personal_vehiculo_personal1_idx` (`id_personal` ASC),
  CONSTRAINT `fk_usuario_vehiculo_vehiculo1`
    FOREIGN KEY (`id_vehiculo`)
    REFERENCES `SMSC_BD`.`vehiculo` (`id_vehiculo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_personal_vehiculo_personal1`
    FOREIGN KEY (`id_personal`)
    REFERENCES `SMSC_BD`.`personal` (`id_personal`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`detalle_personal_vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`detalle_personal_vehiculo` (
  `id_detalle_personal_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `id_personal_vehiculo` INT NOT NULL,
  `id_personal` INT NOT NULL,
  PRIMARY KEY (`id_detalle_personal_vehiculo`),
  INDEX `fk_detalle_usuario_vehiculo_usuario_vehiculo1_idx` (`id_personal_vehiculo` ASC),
  INDEX `fk_detalle_personal_vehiculo_personal1_idx` (`id_personal` ASC),
  CONSTRAINT `fk_detalle_usuario_vehiculo_usuario_vehiculo1`
    FOREIGN KEY (`id_personal_vehiculo`)
    REFERENCES `SMSC_BD`.`personal_vehiculo` (`id_personal_vehiculo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_detalle_personal_vehiculo_personal1`
    FOREIGN KEY (`id_personal`)
    REFERENCES `SMSC_BD`.`personal` (`id_personal`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`tipo_incidente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`tipo_incidente` (
  `id_tipo_incidente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `imagen` BLOB NOT NULL,
  `fecha_registro` DATETIME NOT NULL,
  `fecha_actualizacion` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_tipo_incidente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`incidente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`incidente` (
  `id_incidente` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_incidente` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longuitud` DOUBLE NOT NULL,
  `detalle` VARCHAR(200) NULL,
  `foto` BLOB NULL,
  `fecha_registro` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_incidente`),
  INDEX `fk_incidente_tipo_incidente1_idx` (`id_tipo_incidente` ASC),
  INDEX `fk_incidente_usuario1_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_incidente_tipo_incidente1`
    FOREIGN KEY (`id_tipo_incidente`)
    REFERENCES `SMSC_BD`.`tipo_incidente` (`id_tipo_incidente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_incidente_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `SMSC_BD`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`respuesta_incidente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`respuesta_incidente` (
  `id_respuesta_incidente` INT NOT NULL AUTO_INCREMENT,
  `id_incidente` INT NOT NULL,
  `id_personal_vehiculo` INT NOT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_finalizacion` DATETIME NOT NULL,
  `descripcion` VARCHAR(200) NULL,
  `foto` BLOB NULL,
  `calificacion` TINYINT NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_respuesta_incidente`),
  INDEX `fk_respuesta_incidente_incidente1_idx` (`id_incidente` ASC),
  INDEX `fk_respuesta_incidente_personal_vehiculo1_idx` (`id_personal_vehiculo` ASC),
  CONSTRAINT `fk_respuesta_incidente_incidente1`
    FOREIGN KEY (`id_incidente`)
    REFERENCES `SMSC_BD`.`incidente` (`id_incidente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_respuesta_incidente_personal_vehiculo1`
    FOREIGN KEY (`id_personal_vehiculo`)
    REFERENCES `SMSC_BD`.`personal_vehiculo` (`id_personal_vehiculo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`vehiculo_incidente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`vehiculo_incidente` (
  `id_apoyo_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `id_personal_vehiculo` INT NOT NULL,
  `id_tipo_incidente` INT NOT NULL,
  `foto` BLOB NULL,
  `descripcion` VARCHAR(200) NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `fecha_finalizacion` DATETIME NOT NULL,
  `estado` TINYINT NOT NULL,
  PRIMARY KEY (`id_apoyo_vehiculo`),
  INDEX `fk_vehiculo_incidente_personal_vehiculo1_idx` (`id_personal_vehiculo` ASC),
  INDEX `fk_vehiculo_incidente_tipo_incidente1_idx` (`id_tipo_incidente` ASC),
  CONSTRAINT `fk_vehiculo_incidente_personal_vehiculo1`
    FOREIGN KEY (`id_personal_vehiculo`)
    REFERENCES `SMSC_BD`.`personal_vehiculo` (`id_personal_vehiculo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_vehiculo_incidente_tipo_incidente1`
    FOREIGN KEY (`id_tipo_incidente`)
    REFERENCES `SMSC_BD`.`tipo_incidente` (`id_tipo_incidente`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`recorrido_vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`recorrido_vehiculo` (
  `id_recorrido_vehiculo` INT NOT NULL AUTO_INCREMENT,
  `id_personal_vehiculo` INT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longuitud` DOUBLE NOT NULL,
  `fecha_registro` DATETIME NOT NULL,
  PRIMARY KEY (`id_recorrido_vehiculo`),
  INDEX `fk_recorrido_vehiculo_personal_vehiculo1_idx` (`id_personal_vehiculo` ASC),
  CONSTRAINT `fk_recorrido_vehiculo_personal_vehiculo1`
    FOREIGN KEY (`id_personal_vehiculo`)
    REFERENCES `SMSC_BD`.`personal_vehiculo` (`id_personal_vehiculo`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`control`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`control` (
  `id_control` INT NOT NULL AUTO_INCREMENT,
  `cantidad_falso` INT NOT NULL,
  `cantidad_dias` INT NOT NULL,
  PRIMARY KEY (`id_control`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SMSC_BD`.`control_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SMSC_BD`.`control_usuario` (
  `id_control_usuario` INT NOT NULL AUTO_INCREMENT,
  `fecha_creacion` DATE NOT NULL,
  `fecha_finalizacion` DATE NOT NULL,
  `id_usuario` INT NOT NULL,
  `id_control` INT NOT NULL,
  PRIMARY KEY (`id_control_usuario`),
  INDEX `fk_control_usuario_usuario1_idx` (`id_usuario` ASC),
  INDEX `fk_control_usuario_control1_idx` (`id_control` ASC),
  CONSTRAINT `fk_control_usuario_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `SMSC_BD`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_control_usuario_control1`
    FOREIGN KEY (`id_control`)
    REFERENCES `SMSC_BD`.`control` (`id_control`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;