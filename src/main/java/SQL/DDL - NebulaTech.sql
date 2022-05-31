-- create database nebulatech; 
-- use nebulatech;
-- Criação tabela cliente
CREATE TABLE cliente (
	cd_cliente int not null primary key auto_increment,
	nm_cliente varchar(60) not null,
	genero varchar(15),
	email varchar(60),
	endereco varchar(40),
	estadoCivil varchar(20),
	dataNasc date,
	cpf varchar(14) not null,
	telefone varchar(20)
    );

-- Criação tabela produto
CREATE TABLE produto (
	cd_produto int not null primary key auto_increment,
	nm_produto varchar(60) not null,
	preco float,
	estoque smallint not null,
	descricao varchar(100)
    );

-- Criação tabela vendedor
CREATE TABLE vendedor (	
	cd_vendedor int not null primary key auto_increment,
	nm_vendedor varchar(60) not null,
	usuario varchar(20) not null,
	senha varchar(8) not null
);

-- Criação tabela pedido
CREATE TABLE pedido (
	cd_pedido int not null primary key auto_increment, 
	cd_vendedor int not null,
    cd_cliente int not null,
    CONSTRAINT fk_cd_vendedor FOREIGN KEY (cd_vendedor)
        REFERENCES vendedor (cd_vendedor),
	CONSTRAINT fk_cd_cliente FOREIGN KEY (cd_cliente)
		REFERENCES cliente (cd_cliente),
    dataVenda date not null,
    total float not null
);

-- Criação tabela pedido_detalhe ainda em teste pra alteração em proc
CREATE TABLE pedido_detalhe (
	cd_pedido_detalhe int not null primary key auto_increment,
	cd_produto int not null,
    cd_pedido int not null,
    	CONSTRAINT fk_cd_produto FOREIGN KEY (cd_produto)
        REFERENCES produto (cd_produto),
        CONSTRAINT fk_cd_pedido FOREIGN KEY (cd_pedido)
        REFERENCES pedido (cd_pedido),
	quantidade smallint not null
);