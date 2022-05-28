-- create database nebulatech; 
-- use nebulatech;
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

CREATE TABLE pedido (
    cd_pedido INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    cd_produto INTEGER NOT NULL,
    cd_vendedor INTEGER NOT NULL,
    CONSTRAINT fk_cd_produto FOREIGN KEY (cd_produto)
        REFERENCES produto (cd_produto),
    CONSTRAINT fk_cd_vendedor FOREIGN KEY (cd_vendedor)
        REFERENCES vendedor (cd_vendedor),
    quantidade SMALLINT NOT NULL,
    dataVenda DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into vendedor (cd_vendedor, nm_vendedor, usuario, senha) values 
(1, 'Bruna Gomes Coutinho', 'bruna.gc', '123'),
(2, 'Lucas Oliveira', 'lucas.olv', '123'),
(3, 'William Mazotti', 'william.m', '123'),
(4, 'Alexandre Machado', 'alexandre.m', '123'),
(5, 'Mateus Brito', 'mateus.b', '123'),
(6, 'Ramon Nogueira', 'ramon.n', '123');

insert into cliente (cd_cliente, nm_cliente, genero, email, endereco, estadoCivil, dataNasc, cpf, telefone) values 
(1, 'Marjorie Fabro', 'FEM', 'marjorie@gmail.com', 'R Augusta, 124', 'Solteira', '2000/01/01', '999.999.999-99', '11999999999'),
(2, 'Alex Silva', 'MASC', 'alex@gmail.com', 'Av Liberdade 12', 'Casado', '1968/01/01', '141.141.141-14', '11914141414'),
(3, 'Rafaela Reis', 'FEM', 'rafaela@gmail.com', 'R Conselheiro Ramalho 873', 'Solteira', '1996/01/01', '123.123.123-12', '11912312312');

insert into produto (cd_produto, nm_produto, preco, estoque, descricao) values 
(1, 'Mouse Logitech G703', 600, 150, 'SEM FIO LIGHTSPEED RGB LIGHTSYNC'),
(2, 'Placa de vídeo NVIDIA', 1699, 25, 'GeForce GTX 1660 Ti 1'),
(3, 'Mousepad Razer', 75.60, 45, 'Rosa Grande'),
(4, 'Gabinete Gamer', 349, 20, 'Branco RGB'),
(5, 'Cooler RGB', 239, 65, 'Tamanho 140 mm x 25 mm');
