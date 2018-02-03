CREATE TABLE `member` (
  `member_id` VARCHAR(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `consumption` double DEFAULT '0.0',
  `level` integer DEFAULT '0',
  `point` double DEFAULT '0.0',
  `delete` boolean DEFAULT FALSE,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;