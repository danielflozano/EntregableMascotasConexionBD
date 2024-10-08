-- drop database entregable_mascotas;

create database entregable_mascotas;

use entregable_mascotas;

-- tabla personas
create table personas (
documento varchar(15) primary key not null,
nombre varchar(50) not null,
telefono varchar(10) not null
);

-- tabla mascotas
create table mascotas (
idDueño varchar(15) not null,
nombre varchar(50) not null,
raza varchar(30) not null,
sexo varchar(10) not null,
foreign key (idDueño) references personas(documento)
);