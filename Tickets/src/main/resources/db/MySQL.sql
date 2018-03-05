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

CREATE TABLE `pay` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `money` double DEFAULT '0.0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `venue_seat` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `venue_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` int DEFAULT '0',
  `price` double DEFAULT '0.0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `venue` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `show` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `performance_time` datetime,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `show_id` int(11) NOT NULL,
  `create_time` datetime,
  `seat_name` varchar(255) DEFAULT NULL,
  `number` int DEFAULT '0',
  `status` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;