/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
*
* @author Bruna Gomes
* 
*/

public class Pedido {
   int cd_pedido, cd_cliente, cd_vendedor;
   String data;

    public Pedido() {
        
    }

    public int getCd_pedido() {
        return cd_pedido;
    }

    public void setCd_pedido(int cd_pedido) {
        this.cd_pedido = cd_pedido;
    }

    public int getCd_cliente() {
        return cd_cliente;
    }

    public void setCd_cliente(int cd_cliente) {
        this.cd_cliente = cd_cliente;
    }

    public int getCd_vendedor() {
        return cd_vendedor;
    }

    public void setCd_vendedor(int cd_vendedor) {
        this.cd_vendedor = cd_vendedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
   
   
}
