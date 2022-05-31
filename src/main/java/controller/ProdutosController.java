package controller;

import models.Produto;
import DAO.ProdutosDAO;
import java.util.ArrayList;
/**
 *
 * @author alexandre
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
    public static ArrayList<Produto> Filtar(String filtro){
        return ProdutosDAO.filtrarProdutos(filtro);
    }
    public static void setEstoque(int id, int quant) {
        ProdutosDAO.setEstoque(id, quant);
    }

}
