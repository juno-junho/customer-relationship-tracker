DROP DATABASE IF EXISTS `web_customer_tracker`;
CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `first_name` varchar(45) DEFAULT NULL,
                            `last_name` varchar(45) DEFAULT NULL,
                            `email` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`id`)
);

INSERT INTO `customer` VALUES
(1,'Junho','Hwang','ssmm0205@naver.com'),
(2,'alpha','Kim','kim@gmail.com'),
(3,'Beta','Lee','lee@gmail.com'),
(4,'Theta','Park','park@gmail.com'),
(5,'Omega','Jung','jung@gmail.com');
