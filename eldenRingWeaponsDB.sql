create database if not exists elden_ring_weapons;

use elden_ring_weapons;

drop table if exists weapons;

create table weapons (
	id int(10) not null auto_increment,
    name varchar(50) not null,
    class varchar(50) not null, 
	primary key(id)
);