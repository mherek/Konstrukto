drop database if exists konstrukto;
create database konstrukto;
use konstrukto;
create table radnik (
    id int not null primary key auto_increment,
    ime varchar(50),
    prezime varchar(50),
    oib char(11),
	iban char(21),
	nadredeni int(11) default null,
	napomena varchar(200)
	);
create table gradiliste (
    id int not null primary key auto_increment,
    ime varchar(50),
	adresa varchar(50)
	
);
create table radnikgradiliste(
	id int not null primary key auto_increment,
    vrijemepocetka datetime,
	vrijemekraja  datetime,
    radnik int not null,
    gradiliste int not null
);


create table stroj (
id int not null primary key auto_increment,
model varchar(50),
marka varchar(50),
ime varchar(50)
);

create table strojradnikgradiliste(
id int not null primary key auto_increment,
dankoristenja datetime,
radnik int not null,
stroj int not null,
gradiliste int not null
);

