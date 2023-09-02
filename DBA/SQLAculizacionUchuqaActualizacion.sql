-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd_uchuqa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_uchuqa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_uchuqa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bd_uchuqa` ;

-- -----------------------------------------------------
-- Table `bd_uchuqa`.`etiqueta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`etiqueta` (
  `IdEtiqueta` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdEtiqueta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`Departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`Departamento` (
  `idDepartamento` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`usuario` (
  `IdUsuario` INT NOT NULL AUTO_INCREMENT,
  `Edad` INT NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Contra` VARCHAR(250) NOT NULL,
  `PrimerNombre` VARCHAR(45) NOT NULL,
  `PrimerApellido` VARCHAR(45) NOT NULL,
  `IMGPerfil` VARCHAR(1000) NULL DEFAULT NULL,
  `IMGPortada` VARCHAR(1000) NULL DEFAULT NULL,
  `IdDepartamento` INT NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  INDEX `IdDepartamento_idx` (`IdDepartamento` ASC) VISIBLE,
  CONSTRAINT `IdDepartamento`
    FOREIGN KEY (`IdDepartamento`)
    REFERENCES `bd_uchuqa`.`Departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`proyecto` (
  `IdProyecto` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  `Id_Usuario` INT NOT NULL,
  PRIMARY KEY (`IdProyecto`),
  INDEX `Id_Usuario` (`Id_Usuario` ASC) VISIBLE,
  CONSTRAINT `proyecto_ibfk_1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `bd_uchuqa`.`usuario` (`IdUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`asignacionetiqueta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`asignacionetiqueta` (
  `IdAsignacionEtiqueta` INT NOT NULL,
  `ID_Etiqueta` INT NOT NULL,
  `Proyecto_ID` INT NOT NULL,
  PRIMARY KEY (`IdAsignacionEtiqueta`),
  INDEX `ID_Etiqueta` (`ID_Etiqueta` ASC) VISIBLE,
  INDEX `Proyecto_ID` (`Proyecto_ID` ASC) VISIBLE,
  CONSTRAINT `asignacionetiqueta_ibfk_1`
    FOREIGN KEY (`ID_Etiqueta`)
    REFERENCES `bd_uchuqa`.`etiqueta` (`IdEtiqueta`),
  CONSTRAINT `asignacionetiqueta_ibfk_2`
    FOREIGN KEY (`Proyecto_ID`)
    REFERENCES `bd_uchuqa`.`proyecto` (`IdProyecto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`chat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`chat` (
  `IdChat` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(250) NOT NULL,
  `FechaDeInsercion` DATETIME NOT NULL,
  `Proyect_id` INT NULL DEFAULT NULL,
  `User_ID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`IdChat`),
  INDEX `Proyect_id` (`Proyect_id` ASC) VISIBLE,
  INDEX `User_ID` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `chat_ibfk_1`
    FOREIGN KEY (`Proyect_id`)
    REFERENCES `bd_uchuqa`.`proyecto` (`IdProyecto`),
  CONSTRAINT `chat_ibfk_2`
    FOREIGN KEY (`User_ID`)
    REFERENCES `bd_uchuqa`.`usuario` (`IdUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`comentarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`comentarios` (
  `IdComentario` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(250) NOT NULL,
  `Usua_Id` INT NOT NULL,
  `Id_Proyecto` INT NOT NULL,
  `ID_Comentario` INT NULL,
  PRIMARY KEY (`IdComentario`),
  INDEX `Id_Proyecto` (`Id_Proyecto` ASC) VISIBLE,
  INDEX `Usua_Id` (`Usua_Id` ASC) VISIBLE,
  INDEX `ID_Comentario` (`ID_Comentario` ASC) VISIBLE,
  CONSTRAINT `comentarios_ibfk_1`
    FOREIGN KEY (`Id_Proyecto`)
    REFERENCES `bd_uchuqa`.`proyecto` (`IdProyecto`),
  CONSTRAINT `comentarios_ibfk_2`
    FOREIGN KEY (`Usua_Id`)
    REFERENCES `bd_uchuqa`.`usuario` (`IdUsuario`),
  CONSTRAINT `comentarios_ibfk_3`
    FOREIGN KEY (`ID_Comentario`)
    REFERENCES `bd_uchuqa`.`comentarios` (`IdComentario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`contacto` (
  `IdContacto` INT NOT NULL AUTO_INCREMENT,
  `Correo` VARCHAR(45) NOT NULL,
  `Telefono` INT NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `RedesSociales` VARCHAR(45) NOT NULL,
  `Usuario_ID` INT NOT NULL,
  PRIMARY KEY (`IdContacto`),
  INDEX `Usuario_ID` (`Usuario_ID` ASC) VISIBLE,
  CONSTRAINT `contacto_ibfk_1`
    FOREIGN KEY (`Usuario_ID`)
    REFERENCES `bd_uchuqa`.`usuario` (`IdUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`imagenes` (
  `IdImagen` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(1000) NOT NULL,
  `ID_Proyecto` INT NOT NULL,
  PRIMARY KEY (`IdImagen`),
  INDEX `ID_Proyecto` (`ID_Proyecto` ASC) VISIBLE,
  CONSTRAINT `imagenes_ibfk_1`
    FOREIGN KEY (`ID_Proyecto`)
    REFERENCES `bd_uchuqa`.`proyecto` (`IdProyecto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_uchuqa`.`tipousuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_uchuqa`.`tipousuario` (
  `Id_TipoUsuario` INT NOT NULL AUTO_INCREMENT,
  `DescripcionUsuario` VARCHAR(45) NOT NULL,
  `ID_usuario` INT NOT NULL,
  PRIMARY KEY (`Id_TipoUsuario`),
  INDEX `ID_usuario` (`ID_usuario` ASC) VISIBLE,
  CONSTRAINT `tipousuario_ibfk_1`
    FOREIGN KEY (`ID_usuario`)
    REFERENCES `bd_uchuqa`.`usuario` (`IdUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
