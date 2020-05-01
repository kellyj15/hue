DROP TABLE IF EXISTS `twitter_user`;
CREATE TABLE `twitter_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `twitter_user_id` INT NULL COMMENT '',
  `screen_name` VARCHAR(45) NULL COMMENT '',
  `access_token` VARCHAR(100) NULL COMMENT '',
  `access_token_secret` VARCHAR(100) NULL COMMENT '',
  `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '',
  PRIMARY KEY (`user_id`)  COMMENT '',
  UNIQUE INDEX `twitter_user_id_UNIQUE` (`twitter_user_id` ASC)  COMMENT '');