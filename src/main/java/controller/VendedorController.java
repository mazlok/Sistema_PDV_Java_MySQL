/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.VendedorDAO;

/**
*
* @author Alexandre Machado
* @see DAO.VendedorDAO, models.Vendedor;
*/

public class VendedorController {
    public static void Login(String login) {
        VendedorDAO.login(login);
    }
}
