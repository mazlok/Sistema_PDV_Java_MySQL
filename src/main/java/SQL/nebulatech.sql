create database nebulatech;
use nebulatech;

create table cliente
(cd_cliente int not null primary key auto_increment,
nm_cliente varchar(60) not null,
genero varchar(15),
email varchar(60),
endereco varchar(40),
estadoCivil varchar(20),
dataNasc date,
cpf varchar(14) not null,
telefone varchar(20));

create table produto
(cd_produto int not null primary key auto_increment,
nm_produto varchar(60) not null,
preco float,
estoque smallint not null,
descricao varchar(100));

create table vendedor 
(cd_vendedor int not null primary key auto_increment,
nm_vendedor varchar(60) not null,
usuario varchar(20),
senha varchar(8)
);

create table pedido
(cd_pedido int not null primary key auto_increment,
cd_produto integer not null,
cd_vendedor integer not null,
CONSTRAINT fk_cd_pedido foreign key (cd_produto) REFERENCES produto (cd_produto),
CONSTRAINT fk_cd_pedido foreign key (cd_vendedor) REFERENCES vendedor (cd_vendedor),
quantidade smallint not null,
dataVenda datetime not null default current_timestamp
);

insert into cliente (nm_cliente, genero, email, endereco,
dataNasc, cpf, telefone) values ('Teste cliente', 'Masculino',
'teste@teste.com', 'Rua teste', '20220101', '999.999.999-99',
'11999999999');

insert into produto (nm_produto, preco, quantidade_produto, descricao) 
values ('Teste produto', 100, 100, 'Teste produto');