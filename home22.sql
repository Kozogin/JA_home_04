drop database if exists magazine;
create database magazine char set utf8;
use magazine;
select database();

create table users(
	id int not null primary key auto_increment,
    username varchar(120) not null unique,
    password varchar(30) not null,
    first_name varchar(45) not null,
    last_name varchar(45) not null,
    details text  
);

create table magazine(	
    id int not null primary key auto_increment,
    name varchar(60) not null,
    description text,
    price decimal(6,2) not null,
    isbn varchar(12) not null unique
);

create table magazine_users(	
    users_id int not null,
    magazine_id int not null,
    primary key ( users_id, magazine_id)
);

alter table magazine_users add foreign key (magazine_id) references magazine(id);
alter table magazine_users add foreign key (users_id) references users(id);

insert into users(username, password, first_name, last_name, details) values
	('Greta','12dgdgd548g4hg','Iruna','Gretak','t 0688265675655, good user'
);

insert into magazine(name, description, price, isbn) values
	('Stars', 'about stars', 125.25, 'gt500yut'),
    ('Cars', 'about cars', 155.25, 'gp511ycr'),
    ('Planes', 'about planbes', 175.25, 'pt588ypl'
);

insert into magazine_users(users_id, magazine_id) values
	(1, 1
    
);

#select * from users;
select * from magazine;
#select * from magazine_users;