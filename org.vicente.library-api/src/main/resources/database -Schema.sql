CREATE DATABASE IF NOT EXISTS `librenew`;

USE `librenew`;

CREATE TABLE IF NOT EXISTS `books` (
  `book_id` int(5) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

INSERT INTO `books` (`book_id`, `title`, `category`) VALUES
	(1, 'Java 8', 'Java'),
	(2, 'Hibernate HQL ', 'Hibernate'),
	(3, 'Angular with Spring MVC with Hibernate', 'Spring'); 