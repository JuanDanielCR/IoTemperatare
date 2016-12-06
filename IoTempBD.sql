create database IoTemperature;
use IoTemperature;

create table usuarios(
	idUser int auto_increment primary key,
    email varchar(50) not null,
    pass varchar(50) not null
);

create table temperatura(
	idTemperatura int auto_increment primary key,
    temperatura varchar(5) not null,
    fecha_temperatura timestamp default current_timestamp
);

insert into usuarios(email, pass) values('castilloreyesjuan@gamil.com','123');
insert into temperatura(temperatura) values(21);

select * from usuarios;
select * from temperatura;