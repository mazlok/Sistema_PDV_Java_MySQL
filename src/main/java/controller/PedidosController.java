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
}
