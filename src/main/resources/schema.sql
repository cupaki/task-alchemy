CREATE DATABASE  IF NOT EXISTS `alchemy_directory`;
USE `alchemy_directory`;

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`first_name` varchar(45) DEFAULT NULL,
  	`last_name` varchar(45) DEFAULT NULL,
  	`email` varchar(45) DEFAULT NULL,
  	`role` varchar(45) DEFAULT NULL,
  	 PRIMARY KEY (`id`)
 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES 
	(1,'Dusko','Vesin','dusko@alchemy.cloud', 'CTO'),
	(2,'Nikola','Milinkovic','nikola@alchemy.cloud', 'CTO'),
	(3,'Gordana','Novakovic','gaca@alchemy.cloud', 'HR'),
	(4,'Marko','Gacesa','marko@alchemy.cloud', 'CPO'),
	(5,'Sasha','Novakovich','sasha@alchemy.cloud', 'CEO'),
    (6,'Srdjan','Dobrijevic','dobrijevic.srdjan@gmail.com','candidate')


