create database dbcabelereiro;
use dbcabelereiro;

create table usuario(
id int auto_increment primary key,
login varchar(20) not null,
senha varchar(200) not null
);

create table endereco(
id int auto_increment primary key,
tipo varchar(20) not null,
logradouro varchar(100) not null,
numero varchar(10) not null,
complemento varchar(30),
cep varchar(10)not null,
bairro varchar(40) not null,
cidade varchar(50) not null,
estado char(3) not null
);


create table preco(
id int auto_increment primary key,
preco decimal(10,2) not null
);


create table contato(
id int auto_increment primary key,
telefone varchar(20) not null,
email varchar(100) not null
);


create table cliente(
id int auto_increment primary key,
nome varchar(200) not null,
cpf varchar(15) not null,
sexo char(2) not null,
idendereco int not null,
idcontato int not null,
idusuario int unique not null
);


create table profissional(
id int auto_increment primary key,
nome varchar(200) not null,
funcao varchar(50) not null,
idendereco int not null,
idcontato int not null,
idusuario int unique not null
);


create table servico(
id int auto_increment primary key,
tiposervico varchar(50) not null,
idpreco int not null
);


create table unidade(
id int auto_increment primary key,
idendereco int not null,
idcontato int not null
);

create table horario(
id int auto_increment primary key,
idcliente int not null,
idservico int not null,
idprofissional int not null,
idunidade int not null,
dia date not null,
hora time not null 
);







