CREATE TABLE `quiz`.`quizzes` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `login` INT(5) NOT NULL,
  `subject` INT(5) NOT NULL,
  `theme` INT(5) NOT NULL,
  `questions` INT(5) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`users` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(300) NOT NULL,
  `salt` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`subjects` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`themes` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `quiz`.`questions` (
  `id` INT(5) NOT NULL AUTO_INCREMENT,
  `themeId` INT(5) NOT NULL,
  `question` VARCHAR(300) NOT NULL,
  `answer` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`));


INSERT INTO subjects(subject) VALUES ('History'), ('Geography'), ('English'), ('Geometry');