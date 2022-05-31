-- Criação do relatório analítico
-- Versão 1.0
-- Consultar a procedure no caso de alteração e validar as informações com o banco

CREATE PROCEDURE p_RelAnalitico (pedido int)
SELECT 
p.nm_produto,
pdd.quantidade
FROM pedido_detalhe pdd
JOIN pedido pd on pdd.cd_pedido = pd.cd_pedido
JOIN produto p on pdd.cd_produto = p.cd_produto
where pdd.cd_pedido = pedido;

CALL p_RelAnalitico(1);
