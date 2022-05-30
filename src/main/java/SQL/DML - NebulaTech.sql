-- use nebulatech;

insert into vendedor (nm_vendedor, usuario, senha) values 
('Bruna Gomes Coutinho', 'bruna.gc', '123'),
('Lucas Oliveira', 'lucas.olv', '123'),
('William Mazotti', 'william.m', '123'),
('Alexandre Machado', 'alexandre.m', '123'),
('Mateus Brito', 'mateus.b', '123'),
('Ramon Pinheiro', 'ramon.p', '123');

insert into cliente (nm_cliente, genero, email, endereco, estadoCivil, dataNasc, cpf, telefone) values 
('Marjorie Fabro', 'F', 'marjorie@gmail.com', 'R Augusta, 124', 'Solteiro(a)', '2000/01/01', '999.999.999-99', '11999999999'),
('Alex Silva', 'M', 'alex@gmail.com', 'Av Liberdade 12', 'Casado(a)', '1968/01/01', '141.141.141-14', '11914141414'),
('Rafaela Reis', 'F', 'rafaela@gmail.com', 'R Conselheiro Ramalho 873', 'Solteira(a)', '1996/01/01', '123.123.123-12', '11912312312');

insert into produto (nm_produto, preco, estoque, descricao) values 
('Mouse Logitech G703', 600, 150, 'SEM FIO LIGHTSPEED RGB LIGHTSYNC'),
('Placa de vídeo NVIDIA', 1699, 25, 'GeForce GTX 1660 Ti 1'),
('Mousepad Razer', 75.60, 45, 'Rosa Grande'),
('Gabinete Gamer', 349, 20, 'Branco RGB'),
('Cooler RGB', 239, 65, 'Tamanho 140 mm x 25 mm');

insert into pedido (cd_produto, cd_vendedor, cd_cliente, quantidade, dataVenda) values
(1, 2, 2, 5, '2022-05-25');

select * from vendedor where cd_vendedor = 2;
select * from cliente;
select * from produto;
select * from pedido;