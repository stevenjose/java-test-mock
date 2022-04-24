-- -----------------------------------------------------
-- Schema burger_restaurant
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `burger_restaurant` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `burger_restaurant` ;


-- -----------------------------------------------------
-- Table `burger_restaurant`.`TURN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `burger_restaurant`.`TURN` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `burger_restaurant`.`RESTAURANT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `burger_restaurant`.`RESTAURANT` (
  `ID` INT(45) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(500) NULL DEFAULT NULL,
  `ADDRESS` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `burger_restaurant`.`RESERVATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `burger_restaurant`.`RESERVATION` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `LOCATOR` VARCHAR(100) NULL DEFAULT NULL,
  `PERSON` INT(11) NULL DEFAULT NULL,
  `DATE` DATE NULL,
  `TURN_ID` INT(11) NOT NULL,
  `RESTAURANT_ID` INT(45) NOT NULL,
  PRIMARY KEY (`ID`, `RESTAURANT_ID`),
  INDEX `fk_RESERVATION_TURN1_idx` (`TURN_ID` ASC) VISIBLE,
  INDEX `fk_RESERVATION_RESTAURANT1_idx` (`RESTAURANT_ID` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `burger_restaurant`.`BOARD`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `burger_restaurant`.`BOARD` (
  `ID` INT(45) NOT NULL,
  `CAPACITY` VARCHAR(45) NULL,
  `NUMBER` INT(45) NULL,
  `RESTAURANT_ID` INT(45) NOT NULL,
  PRIMARY KEY (`ID`, `RESTAURANT_ID`),
  INDEX `fk_BOARD_RESTAURANT1_idx` (`RESTAURANT_ID` ASC) VISIBLE,
  CONSTRAINT `fk_BOARD_RESTAURANT1`
    FOREIGN KEY (`RESTAURANT_ID`)
    REFERENCES `burger_restaurant`.`RESTAURANT` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;