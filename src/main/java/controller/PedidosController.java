/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.PedidosDAO;
import DAO.ProdutosDAO;
import DAO.VendedorDAO;
import java.util.ArrayList;
import models.Pedido;
import models.Produto;
import models.RelAnalitico;
import models.RelSintetico;

/**
*
* @author Alexandre Machado
* @see DAO.PedidosDAO, models.Pedido;
*/

public class PedidosController {
    public static int vendasPorVendedor(String vendedor) {
        return PedidosDAO.vendasPorVendedor(vendedor);
    }
    
    public static int criarPedido(int cd_vendedor, int cd_cliente, float total){
        return PedidosDAO.criarPedido(cd_vendedor, cd_cliente, total);
    }
    
    public static void requisitarProduto(int cd_produto, int cd_pedido, int quantidade) {
        PedidosDAO.requisitarProduto(cd_produto, cd_pedido, quantidade);
    }
    
    public static ArrayList<Pedido> Pedidos(String dataMin, String dataMax){
        System.out.println("entrou");
      return PedidosDAO.consultarPedido(dataMin, dataMax);
    }
    
    public static ArrayList<RelAnalitico> Analiticos(int cd_pedido){
        System.out.println("entrou");
      return PedidosDAO.consultarPedidoDetalhado(cd_pedido);
    }
}
