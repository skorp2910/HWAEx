drop database if exists academy;
create database if not exists academy default character set utf8;
use academy;
create table students (
                          id int primary key auto_increment,
                          first_name varchar(255) not null,
                          last_name varchar(255) not null,
                          age int not null,
                          `groupId` int,
                          foreign key (`groupId`) references `groups`(id) on delete SET NULL on update cascade
);
create table `groups`(
    id int primary key auto_increment,
    name varchar(255) not null
)