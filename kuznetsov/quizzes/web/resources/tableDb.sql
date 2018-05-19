CREATE TABLE `quiz`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `pwd` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`quizzes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` INT(5) NOT NULL,
  `subject` INT(5) NOT NULL,
  `theme` INT(5) NOT NULL,
  `questions` INT(5) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`questions` (
  `id` INT NOT NULL,
  `question` VARCHAR(300) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`themes` (
  `id` INT(5) NOT NULL,
  `theme` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`subjects` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));