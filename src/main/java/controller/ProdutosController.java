/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import models.Produto;
import DAO.ProdutosDAO;
import java.util.ArrayList;
/**
 *
 * @author alexa
 */
public class ProdutosController {
    
    public static void Inserir(String nome, String desc, float preco,int quant ){
        ProdutosDAO.adicionarProdutos(nome, desc, preco, quant);
    }
    
    public static ArrayList<Produto> Produtos(){
      return ProdutosDAO.consultarProdutos();
    }
    
    public static void Alterar(int id, String nome, String desc, float preco,int quant ){
        ProdutosDAO.alterarProdutos(id, nome, desc, preco, quant);
    }
    
    public static void Excluir(int id){
        ProdutosDAO.excluirProdutos(id);
    }
}
