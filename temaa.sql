drop database if exists tema;
create database tema;
use tema;

SET FOREIGN_KEY_CHECKS=0;
DELETE FROM COURSES where idc=1;
SET SQL_SAFE_UPDATES = 1;
select * from courses;
drop table STUDENT;
drop table COURSES;

create table client_info(
idc int unique auto_increment primary key,
namec char(20),
card_number int,
 cnp char(20),
 address char(30))
;

select * from employee;

insert into client_info values
(1,'Dregan',12,'2950614','Jibou'),
(2,'Sechel',35,'2951507','Racas'),
(3,'Lazar',56,'2952802','Cuceu');

create table employee(
ide int unique auto_increment primary key,
namee char(20),
age int,
empl_date char(20) );

insert into employee values
(1,'Muresan',37,'16.02.2010'),
(2,'Marian',55,'30.10.2005');

create table account(
ida int unique auto_increment primary key,
typea char(10),
amount double,
creat_date char(10),
ide int,
idc int,
foreign key(idc) references client_info(idc),
foreign key(ide) references employee(ide));

insert into account values
(1,'Spending',200,'01.01.2010',1,1),
(2,'Saving',1000,'02.02.2000',1,2),
(3,'Spending',2000,'04.04.2005',2,3);


select * from account;
create table admin
(usernameadmin char(20),
passwordadmin char(20));

insert into admin values
('admin','adminpass');

create table user(usernameuser char(20),
passworduser char(20));

insert into user values
('user','userpass');



