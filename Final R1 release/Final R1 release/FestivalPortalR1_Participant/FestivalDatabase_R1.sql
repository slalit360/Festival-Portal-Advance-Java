
CREATE DATABASE `festivaldatabase`;

USE `festivaldatabase`;

DROP TABLE IF EXISTS `festivaldatabase`.`event`;
CREATE TABLE  `festivaldatabase`.`event` (
  `eventid` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `description` varchar(40) NOT NULL,
  `places` varchar(40) NOT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `eventtype` varchar(40) DEFAULT NULL,
  `seatsavailable` int(11) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
);

DROP TABLE IF EXISTS `festivaldatabase`.`visitor`;
CREATE TABLE  `festivaldatabase`.`visitor` (
  `visitorid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phonenumber` varchar(15) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`visitorid`)
);

DROP TABLE IF EXISTS `festivaldatabase`.`eventsignup`;
CREATE TABLE  `festivaldatabase`.`eventsignup` (
  `signupid` int(11) NOT NULL AUTO_INCREMENT,
  `eventid` int(11) DEFAULT NULL,
  `visitorid` int(11) DEFAULT NULL,
  PRIMARY KEY (`signupid`),
  KEY `eventid` (`eventid`),
  KEY `visitorid` (`visitorid`),
  CONSTRAINT `eventsignup_ibfk_2`  FOREIGN KEY (`visitorid`) REFERENCES `visitor` (`visitorid`),
  CONSTRAINT `eventsignup_ibfk_3`  FOREIGN KEY (`eventid`) REFERENCES `event` (`eventid`)
);


insert into EVENT(eventid,name,description,places,duration,eventtype,seatsavailable)
values(1001,'Rose Parade','Studies in Botany','New Codington Rose Garden','0900 - 1300','Concert',50),
(1002,'NCCL Cricket League Final','North Town vs. South Town','New Codington Stadium','1300 - 1600','Sporting Event',200),
(1003,'Fireworks Show','Spectacular Display at River','PLACE3','2000 - 2200','',650);


INSERT INTO VISITOR (VISITORID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUMBER)
VALUES ('1001','bsmith','password','Bob','Smith','bsmith@email.com','748937487'),
 ('1002','npatel','password','Nitin','Patel','npatel@email.com','3392382'),
 ('1003','jjones','password','James','Jones','jjones@email.com','2342343244'),
 ('1004','jfrancois','password','Jacques','Francois','jfrancois@email.com','1234567890'),
 ('1005','rkreiger','password','Robert','Kreiger','rkreiger@email.com','49872938'),
 ('1006','ylee','password','Yi-Hui','Lee','ylee@email.com','21239393')
;  
