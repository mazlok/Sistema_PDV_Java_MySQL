/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
*
* @author Alexandre Machado
* 
*/

public class RelSintetico {
    private int cd_pedido, total;
    private String dataVenda,  nm_cliente;

    public RelSintetico() {
        
    }

    public int getCd_pedido() {
        return cd_pedido;
    }

    public void setCd_pedido(int cd_pedido) {
        this.cd_pedido = cd_pedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
}
