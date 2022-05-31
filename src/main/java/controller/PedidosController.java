/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.PedidosDAO;
import DAO.VendedorDAO;

/**
 *
 * @author alexa
 */
public class PedidosController {
    public static int vendasPorVendedor(String vendedor) {
        return PedidosDAO.vendasPorVendedor(vendedor);
    }
    
    public static int criarPedido(int cd_vendedor, int cd_cliente){
        return PedidosDAO.criarPedido(cd_vendedor, cd_cliente);
    }
    
    public static void requisitarProduto(int cd_produto, int cd_pedido, int quantidade) {
        PedidosDAO.requisitarProduto(cd_produto, cd_pedido, quantidade);
    }
    
}
