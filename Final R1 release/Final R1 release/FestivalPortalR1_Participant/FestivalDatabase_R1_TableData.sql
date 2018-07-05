/* Test Data Refresh SQL Script for Release 1*/
/* Directions:  Copy the statements below into mySQL Workbench to add the data into the table in the DEFAULT SCHEMA. */
/* BE SURE TO SET THE DEFAULT SCHEMA TO FESTIVALDATABASE in the SQL EDITOR*/

DELETE FROM EVENTSIGNUP WHERE SIGNUPID >=1;
DELETE FROM EVENT WHERE EVENTID >=1;
DELETE FROM VISITOR WHERE VISITORID >=1;

INSERT INTO EVENT (EVENTID,NAME,DESCRIPTION,PLACES,DURATION,EVENTTYPE,SEATSAVAILABLE)
VALUES ('1001','Rose Parade','Floats, Music and More','Rose Garden','0900-1400','Tour','4000'),
 ('1002','NCCL Semi Finals','North Division Cricket Match','New Codington Stadium','1800-2200','Sporting Event','5000'),
 ('1003','Fireworks Show','Spectacular Display at River','New Codington River Walk','1900-2000','Attraction','1000'),
 ('1004','Garden Tour','Tour the Beautiful Rose Garden','Rose Garden','1000-1400','Tour','1'),
 ('1005','NCCL Championship','North vs. South Cricket Match','New Codington Stadium','1800-2200','Sporting Event','5000'),
 ('1006','Pavlova  - All World Tour','Pavlova in Concert','New Codington Music Hall','1930-2130','Concert','1000')
;  




INSERT INTO VISITOR (VISITORID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL,PHONENUMBER)
VALUES ('1001','bsmith','password','Bob','Smith','bsmith@email.com','748937487'),
 ('1002','npatel','password','Nitin','Patel','npatel@email.com','3392382'),
 ('1003','jjones','password','James','Jones','jjones@email.com','2342343244'),
 ('1004','jfrancois','password','Jacques','Francois','jfrancois@email.com','1234567890'),
 ('1005','rkreiger','password','Robert','Kreiger','rkreiger@email.com','49872938'),
 ('1006','ylee','password','Yi-Hui','Lee','ylee@email.com','21239393')
;  
