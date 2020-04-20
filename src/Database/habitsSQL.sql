DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uuid` 		 varchar(36) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`uuid`) 
) ;


DROP TABLE IF EXISTS `habit`;
CREATE TABLE `habit`  (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT 'HabitTitle',
  `description` varchar(200) DEFAULT NULL COMMENT 'HabitDescription',
  `streakDays` int(10) NULL DEFAULT NULL COMMENT 'Streak days',
  `status` varchar(10) NULL DEFAULT NULL COMMENT 'Is active',
  `name` varchar(100) NULL DEFAULT NULL COMMENT 'userName',
  `streakTime` date NULL DEFAULT NULL,
  `streak` int(10) NULL DEFAULT NULL,
   `flag` varchar(2) NULL DEFAULT NULL COMMENT 'flag',
  PRIMARY KEY (`id`) USING BTREE
) 