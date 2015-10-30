CREATE SCHEMA `stevyqi` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `stevyqi`.`stevyqi_test` (
  `id` INT NOT NULL,
  `name` VARCHAR(64) NULL,
  `create_time` DATETIME NULL,
  `create_by` INT NULL,
  `amount` DECIMAL(20,2) NULL,
  PRIMARY KEY (`id`));