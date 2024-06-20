create database senai_final;
use senai_final;

create table usuario (
idUsuario int primary key auto_increment,
nome varchar(100) not null,
email varchar(100) not null,
senha varchar(100) not null,
cpf char(14) default "0",
telefone varchar(15) not null
);

select * from usuario;