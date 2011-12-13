SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE  TABLE IF NOT EXISTS `user` (
  `id_user` INT(11) NOT NULL ,
  `first_name` TEXT NULL DEFAULT NULL ,
  `last_name` TEXT NULL DEFAULT NULL ,
  `photo` TEXT NULL DEFAULT NULL ,
  `gender` TEXT NULL DEFAULT NULL ,
  `home_city` TEXT NULL DEFAULT NULL ,
  `relationship` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_user`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `authentication`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `authentication` ;

CREATE  TABLE IF NOT EXISTS `authentication` (
  `id_user` INT(11) NOT NULL ,
  `token` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_user`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `icon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icon` ;

CREATE  TABLE IF NOT EXISTS `icon` (
  `id_icon` INT(11) NOT NULL ,
  `prefix` TEXT NULL DEFAULT NULL ,
  `name` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_icon`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE  TABLE IF NOT EXISTS `category` (
  `id_category` INT(11) NOT NULL ,
  `id_icon` INT(11) NOT NULL ,
  `name` TEXT NULL DEFAULT NULL ,
  `plural_name` TEXT NULL DEFAULT NULL ,
  `short_name` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_category`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE  TABLE IF NOT EXISTS `location` (
  `id_location` INT(11) NOT NULL ,
  `address` TEXT NULL DEFAULT NULL ,
  `cross_street` TEXT NULL DEFAULT NULL ,
  `lat` DOUBLE NULL DEFAULT NULL ,
  `lng` DOUBLE NULL DEFAULT NULL ,
  `postal_code` TEXT NULL DEFAULT NULL ,
  `city` TEXT NULL DEFAULT NULL ,
  `state` TEXT NULL DEFAULT NULL ,
  `country` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_location`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `venue`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `venue` ;

CREATE  TABLE IF NOT EXISTS `venue` (
  `id_venue` INT(11) NOT NULL ,
  `id_location` INT(11) NOT NULL ,
  `name` TEXT NULL DEFAULT NULL ,
  `url` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_venue`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `checkin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `checkin` ;

CREATE  TABLE IF NOT EXISTS `checkin` (
  `id_checkin` INT(11) NOT NULL ,
  `id_user` INT(11) NOT NULL ,
  `id_venue` INT(11) NOT NULL ,
  `created_at` INT(11) NULL DEFAULT NULL ,
  `shout` TEXT NULL DEFAULT NULL ,
  `is_mayor` INT(11) NULL DEFAULT NULL ,
  `time_zone` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_checkin`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `icon_size`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `icon_size` ;

CREATE  TABLE IF NOT EXISTS `icon_size` (
  `id_icon_size` INT(11) NOT NULL ,
  `id_icon` INT(11) NOT NULL ,
  `size` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_icon_size`) )
ENGINE = MyISAM
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `user_contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_contact` ;

CREATE  TABLE IF NOT EXISTS `user_contact` (
  `id_user` INT(11) NOT NULL ,
  `phone` TEXT NULL DEFAULT NULL ,
  `email` TEXT NULL DEFAULT NULL ,
  `twitter` TEXT NULL DEFAULT NULL ,
  `facebook` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_user`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `venue_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `venue_category` ;

CREATE  TABLE IF NOT EXISTS `venue_category` (
  `id_venue` INT(11) NOT NULL ,
  `id_category` INT(11) NOT NULL ,
  `primary` INT(11) NOT NULL ,
  PRIMARY KEY (`id_venue`, `id_category`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
